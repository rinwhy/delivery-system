package com.solvd.delivery.utils.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class CustomerStaxParser {

    public static final Logger LOGGER = LogManager.getLogger(CustomerStaxParser.class);
    private static final File FILE = new File("src/main/resources/xml/customers.xml");


    public static void readXML(File file) {

        XMLEventReader reader = null;
        try {
            reader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(file));
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement element = event.asStartElement();
                    switch (element.getName().getLocalPart()) {
                        case "customer":
                            Attribute id = element.getAttributeByName(new QName("id"));
                            LOGGER.info("Customer id: " + id.getValue() + "\n");
                            break;
                        case "name":
                            event = reader.nextEvent();
                            if (event.isCharacters()) {
                                LOGGER.info("Name: " + event.asCharacters().getData() + "\n");
                            }
                            break;
                        case "address":
                            event = reader.nextEvent();
                            if (event.isCharacters()) {
                                LOGGER.info("Address: " + event.asCharacters().getData() + "\n");
                            }
                            break;
                        case "email":
                            event = reader.nextEvent();
                            if (event.isCharacters()) {
                                LOGGER.info("email: " + event.asCharacters().getData() + "\n");
                            }
                            break;
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals("customer")) {
                        LOGGER.info("______________________________" + "\n\n");
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            LOGGER.error("Error reading XML " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (XMLStreamException e) {
                LOGGER.error("Error closing the reader! " + e.getMessage());
            }
        }
    }




}
