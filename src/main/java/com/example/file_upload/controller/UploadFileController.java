package com.example.file_upload.controller;

import com.example.file_upload.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping("/")
    public String index(){
        return "upluadFileView";
    }

    @PostMapping("upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }

        try {
            uploadFileService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
    }
}

