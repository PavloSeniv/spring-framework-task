package com.example.example.demo.upload.controller;

import com.example.example.demo.upload.api.UploadApi;
import com.example.example.demo.upload.service.UploadPointService;
import com.example.example.demo.upload.validator.ValidatorGPX;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class UploadController implements UploadApi {
    private static String uploadDirectory = System.getenv("file_upd_dir") + "/uploads";
    @Autowired
    private UploadPointService uploadPointService;

    @Override
    public ResponseEntity<List<String>> getAllTracks() {
        return ResponseEntity.ok(uploadPointService.getAllTracks());
    }

    @Override
    public ResponseEntity<List<String>> getMatchingPoints(String onePoints, String twoPoints) {
        return ResponseEntity.ok(uploadPointService.compareTracks(onePoints, twoPoints));
    }

    @Override
    public ResponseEntity<String> uploadNewTrack(MultipartFile file) {
        String fileExt = FilenameUtils.getExtension(file.getOriginalFilename());
        String fineN = FilenameUtils.removeExtension(FilenameUtils.getName(file.getOriginalFilename()));
        System.out.println("File name: " + fineN);

        try {
            File f = new File(uploadDirectory);
            if (f.exists()) {
                f.delete();
            }
            f.mkdir();


            Path fileNamePath = Paths.get(uploadDirectory, file.getOriginalFilename());
            Files.write(fileNamePath, file.getBytes());

            if (ValidatorGPX.isValidExtension(fileExt) && ValidatorGPX.isValidSchema(fileNamePath)) {
                uploadPointService.createTrackPoints(fileNamePath.toString(), FilenameUtils.removeExtension(FilenameUtils.getName(file.getOriginalFilename())));
                return ResponseEntity.ok("File add to db !");
            }

            return ResponseEntity.ok("File uploads");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error url: " + e.getMessage());
        }
    }
}
