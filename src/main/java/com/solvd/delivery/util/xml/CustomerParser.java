package com.solvd.delivery.util.xml;

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
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class CustomerParser {

    public static final Logger LOGGER = LogManager.getLogger(CustomerParser.class);
    private static final String FILEPATH = "src/main/resources/xml/customers.xml";


    public static void main(String[] args) {

        try {
            readXML();
        } catch (FileNotFoundException | XMLStreamException e) {
            LOGGER.error("Error occurred parsing the XML! " + e.getMessage());
        }
    }

    private static void readXML() throws FileNotFoundException, XMLStreamException {

        XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream(FILEPATH));

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
    }
}
