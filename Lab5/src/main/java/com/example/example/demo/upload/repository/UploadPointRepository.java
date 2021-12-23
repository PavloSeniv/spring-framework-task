package com.example.example.demo.upload.repository;

import com.example.example.demo.upload.entity.UploadPoint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UploadPointRepository extends CrudRepository<UploadPoint, Long> {
    @Query(value = "select distinct points_Name from upload_Point", nativeQuery = true)
    List<String> findAllTracks();

    @Query(value = "select a.points_String from upload_point a, upload_point b where a.points_Name=?1 and b.points_Name=?2 and a.points_String = b.points_String", nativeQuery = true)
    List<String> findMatchingPoints(String mainTrack, String trackToCompare);
}
