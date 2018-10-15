package com.example.demo.dao;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangzi
 * @Date: 2018/10/12 14:45
 */
public interface BaseDao<T> {
    int create(T t);

    int creates(List<T> t);

    int delete(Long id);

    int deletes(List<Long> ids);

    int update(T t);

    T load(Long id);

    List<T> loads(List<Long> ids);

    List<T> list(Map<String, Object> criteria);

    List<T> list(T t);

    List<T> paging(Map<String, Object> criteria);

    List<Long> pagingIds(Map<String, Object> criteria);

    List<Long> listIds(Map<String, Object> criteria);

    Long count(Map<String, Object> criteria);
}
