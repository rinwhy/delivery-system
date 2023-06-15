package com.solvd.delivery.utils.jaxB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxBUtil {

    private static final Logger LOGGER = LogManager.getLogger(JaxBUtil.class);

    //from Java to XML
    public static <T> void marshalling(IJaxB<T> targetClass, File filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(targetClass.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(targetClass, filePath);
        } catch (JAXBException e) {
            LOGGER.error("JAXB Exception " + e.getMessage());
            e.printStackTrace();
        }
    }

    //from xml to java
    public static <T> T unMarshalling(Class<T> targetClass, File filePath) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(targetClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            return (T) unmarshaller.unmarshal(filePath);

        } catch (JAXBException e) {
            LOGGER.error("JAXB Exception " + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.info("returning null");
        return null;
    }

}
