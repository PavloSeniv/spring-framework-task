package com.example.demo.calculate;

public class Converter {
    public static String latLonToString(Coordinates coordinates, double northlat, double eastlon, double westlon, double soutlat) {
        String[][] strings = {
                {"1", "2"},
                {"3", "4"}
        };
        int indexLat;
        int indexLon;
        double middlleLon = (eastlon + westlon) / 2;
        double middlleLat = (northlat + soutlat) / 2;
        if (coordinates.getLon() <= middlleLon)
            indexLon = 0;
        else indexLon = 1;
        if (coordinates.getLat() <= middlleLat)
            indexLat = 1;
        else indexLat = 0;
        return strings[indexLat][indexLon];
    }
}
