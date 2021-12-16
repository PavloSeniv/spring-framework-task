package com.example.demo;

import com.example.demo.model.Model;
import com.example.demo.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.calculate.Converter;
import com.example.demo.calculate.Coordinates;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
//}

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	private List<Coordinates> parseCoordinates(String fileName) {
		List<Coordinates> coordinatesList = new ArrayList<>();
		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory
					= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("trkpt");
			for (int i = 0, l = nList.getLength(); i < l; i++) {
				Node nNode = nList.item(i);
				Element element = (Element) nNode;
				String lat = element.getAttribute("lat");
				String lon = element.getAttribute("lon");
				coordinatesList.add(new Coordinates(Double.valueOf(lat), Double.valueOf(lon)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coordinatesList;
	}
	@Bean
	public CommandLineRunner demo(Repository repository) {
		return (args) -> {
			List<Coordinates> coordinatesList = this.parseCoordinates("71.gpx");
			for (Coordinates i : coordinatesList) {
				String result = Converter.latLonToString(new Coordinates(i.getLat(), i.getLon()), 90, 180, -180, -90);
				repository.save(new Model(i.getLat(), i.getLon(), result));
			}
		};
	}
}
