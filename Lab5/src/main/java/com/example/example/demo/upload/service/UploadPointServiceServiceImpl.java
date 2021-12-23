package com.example.example.demo.upload.service;

import com.example.example.demo.upload.consts.ConstCoordinates;
import com.example.example.demo.upload.entity.PointsCoordinates;
import com.example.example.demo.upload.entity.UploadPoint;
import com.example.example.demo.upload.repository.UploadPointRepository;
import com.example.example.demo.upload.util.ParserGPX;
import com.example.example.demo.upload.util.GeneratorCoordinatesKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UploadPointServiceServiceImpl implements UploadPointService {
    @Autowired
    private UploadPointRepository uploadPointRepository;

    @Override
    public List<String> getAllTracks() {
        return uploadPointRepository.findAllTracks();
    }

    @Override
    public List<String> compareTracks(String mainTrack, String trackToCompare) {
        return uploadPointRepository.findMatchingPoints(mainTrack, trackToCompare);
    }

    @Override
    public void createTrackPoints(String pathFile, String fileName) {
        System.out.println("The file is: " + pathFile);

        try {
            ParserGPX parser = new ParserGPX(pathFile);
            Set<String> keys = new HashSet<>();
            List<PointsCoordinates> pointsCoordinates = parser.parsePoints();
            pointsCoordinates.forEach(p -> {
                GeneratorCoordinatesKey.genKey(ConstCoordinates.MIN_LON, ConstCoordinates.MAX_LON, ConstCoordinates.MIN_LAT, ConstCoordinates.MAX_LAT, p, "", ConstCoordinates.ZOOM, keys);
            });

            keys.forEach(key -> {
                uploadPointRepository.save(new UploadPoint(fileName, key));
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
