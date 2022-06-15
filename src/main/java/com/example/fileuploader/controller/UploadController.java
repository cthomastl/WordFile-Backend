package com.example.fileuploader.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@CrossOrigin("http://localhost:3000")
@RestController
public class UploadController {

    @GetMapping("/index")
    public String Hello() {
        return "uploader";
    }
    @PostMapping(value = "/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file")MultipartFile file){
        String fileName = file.getOriginalFilename().toString();

        try {
            file.transferTo( new File(fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("File uploaded successfully.");
    }
}
