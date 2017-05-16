package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.BaseEntity;

import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
public interface Dao<T extends BaseEntity> {

    int add(T t);

    List<T> findAll();

}
