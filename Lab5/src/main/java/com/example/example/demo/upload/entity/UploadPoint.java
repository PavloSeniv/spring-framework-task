package com.example.example.demo.upload.entity;

import javax.persistence.*;

@Entity
@Table(name = "uploadPoint")
public class UploadPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pointsName;
    private String pointsString;

    public UploadPoint() {
    }

    public UploadPoint(String pointsName, String pointsString) {
        this.pointsName = pointsName;
        this.pointsString = pointsString;
    }
}