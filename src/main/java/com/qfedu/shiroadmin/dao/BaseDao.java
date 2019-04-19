package com.qfedu.shiroadmin.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

    List<T> selectPage(Map<String,Object> map);
    int inser(T t);
}
