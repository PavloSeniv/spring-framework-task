package com.example.example.demo.upload.util;

import com.example.example.demo.upload.entity.PointsCoordinates;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserGPX {
    private File file;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;

    public ParserGPX(String pathToGpx) throws ParserConfigurationException, IOException, SAXException {
        file = new File(pathToGpx);
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(file);
    }

    public List<PointsCoordinates> parsePoints() {
        List<PointsCoordinates> pointsCoordinates = new ArrayList<>();
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("trkpt");
        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element attr = (Element) nList.item(i);
                double lat = Double.parseDouble(attr.getAttribute("lat"));
                double lon = Double.parseDouble(attr.getAttribute("lon"));
                pointsCoordinates.add(new PointsCoordinates(lat, lon));
            }
        }
        System.out.println(pointsCoordinates.size() + "size");
        return pointsCoordinates;
    }
}
