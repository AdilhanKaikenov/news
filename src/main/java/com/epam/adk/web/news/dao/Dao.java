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

    int countRowsNumber();

    T read(int id);

    T save(T t);

    List<T> findPaginated(int pageNumber, int pageSize);

    List<T> findAll();

    void delete(T t);

    void deleteAll(List<T> list);

}
