package com.example.example.demo.upload.entity;

public class PointsCoordinates {
    private double lat;
    private double lon;

    public PointsCoordinates(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "PointsCoordinates{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
