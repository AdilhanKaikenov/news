package com.epam.adk.web.news.service;

import com.epam.adk.web.news.dao.NewsDao;
import com.epam.adk.web.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    public int getNewsNumber() {
        return newsDao.countRowsNumber();
    }

    public News readNews(Integer id) {
        return newsDao.read(id);
    }

    public News saveOrEditNews(News news) {
        return newsDao.save(news);
    }

    public List<News> readAllNews() {
        return newsDao.findAll();
    }

    public void deleteNews(int id) {
        News news = newsDao.read(id);
        newsDao.delete(news);
    }

    public void deleteNewsList(List<News> newsList) {
        newsDao.deleteAll(newsList);
    }

    public List<News> readAllNewsByParameters(String title, Date from, Date to) {
       return newsDao.findByParameters(title, from, to);
    }

    public List<News> getNewsPaginated(int pageNumber, int pageSize) {
        return newsDao.findPaginated(pageNumber, pageSize);
    }
}
