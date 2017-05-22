package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/19/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Repository
@Qualifier("HibernateJpaNewsDao")
public class HibernateJpaNewsDao implements NewsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public News read(int id) {
        Query query = getSession().getNamedQuery("News.readById");
        query.setParameter("id", id);
        return (News) query.uniqueResult();
    }

    @Override
    public int save(News news) {

        Session session = getSession();
        Query query = session.getNamedQuery("News.save");
        setNewsQueryParameters(news, query);
        query.executeUpdate();
        int id = getAutoIncrementID(session);
        news.setId(id);
        return id;
    }

    @Override
    public void saveOrUpdate(News news) {
        Session session = getSession();
        if ((news.getId() == 0)) {
            save(news);
        } else {
            Query query = session.getNamedQuery("News.update");
            setNewsQueryParameters(news, query);
            query.setParameter("id", news.getId());
            query.executeUpdate();
        }
    }

    @Override
    public List<News> findAll() {

        Query query = getSession().getNamedQuery("News.readAll");
        return query.list();
    }

    @Override
    public void delete(News news) {
        Query query = getSession().getNamedQuery("News.deleteById");
        query.setParameter("id", news.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteAll(List<News> list) {

        List<Integer> idList = new ArrayList<>();

        for (News news : list) {
            idList.add(news.getId());
        }

        Query query = getSession().getNamedQuery("News.deleteList");
        query.setParameterList("idList", idList);
        query.executeUpdate();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private void setNewsQueryParameters(News news, Query query) {
        query.setParameter("title", news.getTitle());
        query.setParameter("brief", news.getBrief());
        query.setParameter("datetime", news.getDate());
        query.setParameter("content", news.getContent());
    }

    private int getAutoIncrementID(Session session) {
        String sql = "SELECT NEWS_SEQ.currval FROM dual";
        SQLQuery query = session.createSQLQuery(sql);
        return ((BigDecimal)query.list().get(0)).intValue();
    }
}
