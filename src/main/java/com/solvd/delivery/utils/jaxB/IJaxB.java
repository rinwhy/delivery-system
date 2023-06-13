package com.solvd.delivery.utils.jaxB;

import java.util.List;

public interface IJaxB <T> {
    List<T> getList();
    void setList(List<T> list);

}
