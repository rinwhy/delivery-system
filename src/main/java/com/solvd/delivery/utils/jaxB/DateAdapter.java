package com.solvd.delivery.utils.jaxB;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public String marshal(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    @Override
    public Date unmarshal(String string) {
        return Date.valueOf(string);
    }


}
