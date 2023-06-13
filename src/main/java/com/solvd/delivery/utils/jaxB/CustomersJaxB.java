package com.solvd.delivery.utils.jaxB;

import com.solvd.delivery.bin.Customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersJaxB implements IJaxB<Customer> {

    @XmlElement(name = "customer")
    private List<Customer> customersList = null;

    @Override
    public List<Customer> getList() {
        return customersList;
    }

    @Override
    public void setList(List<Customer> list) {
        this.customersList = list;
    }
}
