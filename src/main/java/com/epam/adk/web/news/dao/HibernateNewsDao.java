package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.epam.adk.web.news.util.ConstantHolder.DATE_PROPERTY_NAME;

/**
 * TODO: Comment
 * <p>
 * Created on 5/19/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Repository
@Qualifier("HibernateNewsDao")
public class HibernateNewsDao implements NewsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public News read(int id) {
        return (News) sessionFactory.getCurrentSession().get(News.class, id);
    }

    @Transactional
    @Override
    public int save(News news) {
        return (int) sessionFactory.getCurrentSession().save(news);
    }

    @Override
    public void saveOrUpdate(News news) {
        sessionFactory.getCurrentSession().saveOrUpdate(news);
    }

    @Override
    public List<News> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(News.class);
        criteria.addOrder(Order.desc(DATE_PROPERTY_NAME));
        return criteria.list();
    }

    @Override
    public void delete(News news) {
        sessionFactory.getCurrentSession().delete(news);
    }

    @Override
    public void deleteAll(List<News> list) {
        for (News news : list) {
            sessionFactory.getCurrentSession().delete(news);
        }
    }
}
