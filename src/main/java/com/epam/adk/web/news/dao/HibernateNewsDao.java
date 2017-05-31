package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
public class HibernateNewsDao implements NewsDao, Dao<News> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int countRowsNumber() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);
        criteria.setProjection(Projections.rowCount());
        return Math.toIntExact((Long) criteria.uniqueResult());
    }

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
    public void update(News news) {
        sessionFactory.getCurrentSession().update(news);
    }

    @Override
    public List<News> findPaginated(int pageNumber, int pageSize) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);
        criteria.addOrder(Order.desc(DATE_PROPERTY_NAME));
        criteria.setFirstResult((pageNumber - 1) * pageSize);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }

    @Override
    public List<News> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);
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

    @Override
    public List<News> findByParameters(String title, Date from, Date to) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);

        if (!title.equals("")) {
            criteria.add(Restrictions.eq("title", title));
        }

        if (from != null) {
            criteria.add(Restrictions.ge("date", from));
        }

        if (to != null) {
            criteria.add(Restrictions.le("date", to));
        }

        return (List<News>) criteria.list();
    }
}
