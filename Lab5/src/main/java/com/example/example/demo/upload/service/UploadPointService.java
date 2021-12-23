package com.example.example.demo.upload.service;

import java.util.List;

public interface UploadPointService {
    void createTrackPoints(String pathFile, String fileName);

    List<String> getAllTracks();

    List<String> compareTracks(String mainTrack, String trackToCompare);
}
