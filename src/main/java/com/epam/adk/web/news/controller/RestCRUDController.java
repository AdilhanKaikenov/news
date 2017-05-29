package com.epam.adk.web.news.controller;

import com.epam.adk.web.news.model.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/25/2017.
 *
 * @author Kaikenov Adilkhan
 */
public interface RestCRUDController<T extends BaseEntity> {

    ResponseEntity<T> create(T t);

    ResponseEntity<T> read(int id);

    ResponseEntity<List<T>> readList();

    ResponseEntity<T> update(T t);

    ResponseEntity<T> delete(int id);

    ResponseEntity<T> deleteAll(List<T> newsList);

}
