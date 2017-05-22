package com.epam.adk.web.news.service;

import com.epam.adk.web.news.dao.NewsDao;
import com.epam.adk.web.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Service
@Transactional
public class NewsService {

    @Autowired
    @Qualifier("HibernateJpaNewsDao")
    private NewsDao newsDao;

    public News readNews(int id) {
        return newsDao.read(id);
    }

    public int addNews(News news) {
        return newsDao.save(news);
    }

    public void addOrEditNews(News news) {
        newsDao.saveOrUpdate(news);
    }

    public List<News> readAllNews() {
        return newsDao.findAll();
    }

    public void deleteNews(int id) {
        News news = newsDao.read(id);
        newsDao.delete(news);
    }
}
