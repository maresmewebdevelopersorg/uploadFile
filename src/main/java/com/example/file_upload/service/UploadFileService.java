package com.example.file_upload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class UploadFileService {

    private String upload_folder = ".//src//main//resources//files//";

    public void saveFile(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload_folder + file.getOriginalFilename());
            Files.write(path,bytes);
        }
    }

    public void saveMultipleFiles(List<MultipartFile> files) throws IOException {
        for(MultipartFile file: files){
            if(file.isEmpty()) continue;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload_folder + file.getOriginalFilename());
            Files.write(path,bytes);
        }
    }
}
