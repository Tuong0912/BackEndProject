package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@CrossOrigin("*")
@RequestMapping("appStore")
public class AppStoreController {
    @GetMapping("/download-html")
    public ResponseEntity<byte[]> downloadHTML() throws IOException {
        FileSystemResource resource = new FileSystemResource("C:\\Users\\Admin\\WebstormProjects\\Big Project\\login\\login.html");

        byte[] htmlBytes = Files.readAllBytes(Path.of(resource.getURI()));

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(htmlBytes);
    }

}
