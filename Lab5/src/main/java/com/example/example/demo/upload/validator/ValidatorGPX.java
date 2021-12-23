package com.example.example.demo.upload.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

public class ValidatorGPX {
    private ValidatorGPX() {
    }

    public static boolean isValidExtension(String ext) {
        return "gpx".equals(ext);
    }

    public static boolean isValidSchema(Path path) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new URL("http://www.topografix.com/GPX/1/1/gpx.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(path.toFile()));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}

