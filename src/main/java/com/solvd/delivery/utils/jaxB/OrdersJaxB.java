package com.solvd.delivery.utils.jaxB;

import com.solvd.delivery.bin.Order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersJaxB implements IJaxB<Order> {

    @XmlElement(name = "order")
    private List<Order> orderList = null;

    @Override
    public List<Order> getList() {
        return orderList;
    }

    @Override
    public void setList(List<Order> list) {
        this.orderList = list;
    }
}
