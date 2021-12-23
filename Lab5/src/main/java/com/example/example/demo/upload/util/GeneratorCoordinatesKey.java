package com.example.example.demo.upload.util;

import com.example.example.demo.upload.entity.PointsCoordinates;

import java.util.Set;

public class GeneratorCoordinatesKey {
    private GeneratorCoordinatesKey() {
    }

    public static void genKey(double minLon, double maxLon, double minLat, double maxLat, PointsCoordinates p, String code, int zoom, Set<String> keys) {
        boolean lrPos = false;
        boolean lhPos = false;

        double midLonVal = maxLon - (maxLon - minLon) / 2;
        double midLatVal = maxLat - (maxLat - minLat) / 2;

        if (p.getLon() * 2 >= midLonVal) lrPos = true;
        if (p.getLat() * 2 >= midLatVal) lhPos = true;

        double nextMinLon = 0, nextMaxLon = 0, nextMinLat = 0, nextMaxLat = 0;

        if (lrPos && lhPos) {
            code += "N";
            nextMinLon = midLonVal;
            nextMaxLon = maxLon;
            nextMinLat = midLatVal;
            nextMaxLat = maxLat;
        } else if (!lrPos && !lhPos) {
            code += "S";
            nextMinLon = minLon;
            nextMaxLon = midLonVal;
            nextMinLat = minLat;
            nextMaxLat = midLatVal;
        } else if (!lrPos && lhPos) {
            code += "W";
            nextMinLon = minLon;
            nextMaxLon = midLonVal;
            nextMinLat = midLatVal;
            nextMaxLat = maxLat;
        } else if (lrPos && !lhPos) {
            code += "E";
            nextMinLon = midLonVal;
            nextMaxLon = maxLon;
            nextMinLat = minLat;
            nextMaxLat = midLatVal;
        }
        if (--zoom != 0) genKey(nextMinLon, nextMaxLon, nextMinLat, nextMaxLat, p, code, zoom, keys);
        else keys.add(code);
    }

}
