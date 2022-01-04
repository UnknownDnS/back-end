package com.unstar.backend.dto.response;

import lombok.Data;

@Data
public class FileUploadResponseDTO {

    /**
     * originalFilename: 클라이언트 파일시스템에서 파일 이름
     * contentType: 파일 유형
     * szFile: 파일 크기
     * paramsName: multipart form 의 parameters 이름
     */
   String originalFilename;
   String contentType;
   Long fileSize;
   String paramsName;

}
