package com.solvd.delivery.service.impl;

import com.solvd.delivery.bin.Delivery;
import com.solvd.delivery.utils.JacksonUtil;

import java.io.File;

public class JsonService {

    public void serializeObjectToJson(Object object, File file) {
        JacksonUtil.serializeObject(object, file);
    }

    public <T> T deserializeJsonToObject(Class<T> object, File file) {
       return JacksonUtil.deserializeToObject(object, file);
    }




}
