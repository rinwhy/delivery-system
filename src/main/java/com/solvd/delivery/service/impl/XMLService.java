package com.solvd.delivery.service.impl;

import com.solvd.delivery.utils.jaxB.IJaxB;
import com.solvd.delivery.utils.jaxB.JaxBUtil;
import com.solvd.delivery.utils.stax.CustomerStaxParser;
import com.solvd.delivery.utils.stax.XMLValidator;

import java.io.File;

public class XMLService {

    public boolean validateXML(String xmlPath, String xsdPath) {
        return XMLValidator.validateXML(xmlPath, xsdPath);
    }

    public boolean validateXML(File xml, File xsd) {
        return XMLValidator.validateXML(xml, xsd);
    }

    public void readCustomerXMLStax(File file) {
        CustomerStaxParser.readXML(file);
    }


    public <T> void marshallToXMLJaxB(IJaxB<T> targetClass, File filePath) {
        JaxBUtil.marshalling(targetClass, filePath);
    }

    public <T> IJaxB unmarshallFromXMLJaxB(Class<T> targetClass, File filePath) {
        return JaxBUtil.unMarshalling(targetClass, filePath);
    }

}
