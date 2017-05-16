package com.epam.adk.web.news.service;

import com.epam.adk.web.news.dao.NewsDao;
import com.epam.adk.web.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: Comment
 *
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public int addNews(News news) {
        return newsDao.add(news);
    }

    public List<News> readAllNews() {
        return newsDao.findAll();
    }

}
