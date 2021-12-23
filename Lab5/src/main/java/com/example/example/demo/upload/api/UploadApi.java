package com.example.example.demo.upload.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api/upload")
public interface UploadApi {
    @GetMapping(value = "/every")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<String>> getAllTracks();

    @GetMapping(value = "/onePoints={onePoints}&twoPoints={twoPoints}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<String>> getMatchingPoints(@PathVariable String onePoints, @PathVariable String twoPoints);

    @PostMapping("/uploads")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<String> uploadNewTrack(@RequestParam("uploadsFile") MultipartFile file);
}
