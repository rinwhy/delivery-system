package com.solvd.delivery.utils.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {

    public static final Logger LOGGER = LogManager.getLogger(XMLValidator.class);


    public static boolean validateXML(String xml, String xsd) {

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xml)) {
            });
        } catch (IOException | SAXException e) {
            LOGGER.warn("Error validating the XML!" + e.getMessage());
            return false;
        }

        LOGGER.info("Validation Successful");
        return true;
    }

    public static boolean validateXML(File xml, File xsd) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml) {
            });
        } catch (IOException | SAXException e) {
            LOGGER.warn("Error validating the XML!" + e.getMessage());
            return false;
        }

        LOGGER.info("Validation Successful");
        return true;
    }


}
