package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;

import java.util.Date;
import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
public interface NewsDao extends Dao<News> {

    List<News> findByParameters(String title, Date from, Date to);

}
