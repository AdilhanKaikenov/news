package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: Comment
 *
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Repository
public class HibernateNewsDao implements NewsDao {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public HibernateNewsDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public News read(int id) {
        return hibernateTemplate.get(News.class, id);
    }

    @Transactional
    @Override
    public int add(News news) {
        return (int) hibernateTemplate.save(news);
    }

    @Override
    public List<News> findAll() {
        return hibernateTemplate.loadAll(News.class);
    }

    @Override
    public void delete(News news) {
        hibernateTemplate.delete(news);
    }
}
