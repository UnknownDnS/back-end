package com.unstar.backend.dto.response;

import lombok.Data;
import org.springframework.core.io.Resource;

import java.io.File;

@Data
public class FileDownloadResponseDTO {

    String filename;
    File file;
    Resource resource;
    //file vs resource?
}
