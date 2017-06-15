package com.epam.adk.web.news.soap;

import com.epam.adk.web.news.model.BaseEntity;

import javax.jws.WebService;
import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/25/2017.
 *
 * @author Kaikenov Adilkhan
 */
@WebService
public interface SoapWebService<T extends BaseEntity> {

    T create(T t);

    T read(int id);

    T update(T t);

    void delete(int id);

    void deleteAll(List<Integer> idList);

}
