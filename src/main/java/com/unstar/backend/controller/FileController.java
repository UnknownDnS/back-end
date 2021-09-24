package com.unstar.backend.controller;

import com.unstar.backend.dto.response.FileDownloadResponseDTO;
import com.unstar.backend.dto.response.FileUploadResponseDTO;
import com.unstar.backend.dto.response.RootResponseDTO;
import com.unstar.backend.exception.StorageFileNotFoundException;
import com.unstar.backend.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/api/file") @Slf4j
@RestController
public class FileController {


    private final StorageService storageService;

    @Autowired
    public FileController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping(value="/list")
    public RootResponseDTO<List<String>> listUploadedFiles() throws IOException {
        log.info("[+] FileController -> list File paths with nothing:");
        List<String> paths = storageService.loadAll().map(path -> path.getFileName().toString()).collect(Collectors.toList());
        /*model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));*/
        return new RootResponseDTO<List<String>>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(paths)
                .build();
    }


    @PostMapping(value="/upload")
    public RootResponseDTO<FileUploadResponseDTO> uploadFile(MultipartFile file){

        log.info("[+] FileController -> upload File with MultipartFile:"+ file);
        storageService.store(file);
        FileUploadResponseDTO fileUploadResponseDTO = new FileUploadResponseDTO();
        fileUploadResponseDTO.setOriginalFilename(file.getOriginalFilename());
        fileUploadResponseDTO.setContentType(file.getContentType());
        fileUploadResponseDTO.setFileSize(file.getSize());
        fileUploadResponseDTO.setParamsName(file.getName());
        return new RootResponseDTO<FileUploadResponseDTO>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(fileUploadResponseDTO)
                .build();
    }

    @GetMapping(value="/info/{filename}")
    public RootResponseDTO<FileDownloadResponseDTO> getFileInfo(@PathVariable String filename) throws IOException {
        log.info("[+] FileController -> get file information with filename:"+ filename);
        Resource file = storageService.loadAsResource(filename);

        Resource resource = storageService.loadAsResource(filename);
        FileDownloadResponseDTO fileDownloadResponseDTO = new FileDownloadResponseDTO();
        fileDownloadResponseDTO.setFilename(resource.getFilename());
        fileDownloadResponseDTO.setFile(resource.getFile());
        fileDownloadResponseDTO.setResource(resource);
        return new RootResponseDTO<FileDownloadResponseDTO>()
                .code(HttpStatus.OK.value())
                .errorMsg(null)
                .response(fileDownloadResponseDTO)
                .build();
        /*return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);*/
    }

    @GetMapping("/download/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> download(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }//*/

    /* 위에게 정상작동시, 사용자별 파일 업로드 다운로드 추가 예정
    * 근데,, 인증을 jwtToken기반으로 검사후,,업로드?
    * 파일 업로드시 ,, id, password.
    * uploadFileByUser
    * downloadFileByUser
    * ...사용자와 어떻게 연결시킬지(userId?, nickName? )
    * */


    /**아래 2개는 보류**/
    /*@GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }//*/
    /*
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }//*/

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }


}
