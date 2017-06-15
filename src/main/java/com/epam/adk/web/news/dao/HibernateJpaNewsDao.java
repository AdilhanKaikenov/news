package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.adk.web.news.util.ConstantHolder.*;

/**
 * TODO: Comment
 * <p>
 * Created on 5/19/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Repository
@Qualifier("HibernateJpaNewsDao")
@Transactional
public class HibernateJpaNewsDao implements NewsDao, Dao<News> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int countRowsNumber() {
        Query query = getSession().getNamedQuery(NAMED_QUERY_NEWS_COUNT_ROWS);
        return Math.toIntExact((Long) query.uniqueResult());
    }

    @Override
    public News read(int id) {
        Query query = getSession().getNamedQuery(NAMED_QUERY_NEWS_READ_BY_ID);
        query.setParameter(ID_PARAMETER, id);
        return (News) query.uniqueResult();
    }

    @Override
    public News save(News news) {
        if ((news.getId() == ZERO)) {
            getSession().save(news);
        } else {
            Query query = getSession().getNamedQuery(NAMED_QUERY_NEWS_UPDATE);
            setNewsQueryParameters(news, query);
            query.setParameter(ID_PARAMETER, news.getId());
            query.executeUpdate();
        }
        return news;
    }

    @Override
    public List<News> findPaginated(int pageNumber, int pageSize) {
        Query query = getSession().getNamedQuery(NAMED_QUERY_NEWS_READ_ALL);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public List<News> findAll() {
        Query query = getSession().getNamedQuery(NAMED_QUERY_NEWS_READ_ALL);
        return query.list();
    }

    @Override
    public void delete(News news) {
        Query query = getSession().getNamedQuery(NAMED_QUERY_NEWS_DELETE_BY_ID);
        query.setParameter(ID_PARAMETER, news.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteAll(List<News> list) {
        List<Integer> idList = new ArrayList<>();
        for (News news : list) {
            idList.add(news.getId());
        }
        Query query = getSession().getNamedQuery(NAMED_QUERY_NEWS_DELETE_LIST);
        query.setParameterList(ID_LIST, idList);
        query.executeUpdate();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private void setNewsQueryParameters(News news, Query query) {
        query.setParameter(TITLE_PARAMETER, news.getTitle());
        query.setParameter(BRIEF_PARAMETER, news.getBrief());
        query.setParameter(DATETIME_PARAMETER, news.getDate());
        query.setParameter(CONTENT_PARAMETER, news.getContent());
    }

    @Override
    public List<News> findByParameters(String title, Date from, Date to) {
        StringBuilder builder = new StringBuilder("FROM News n");
        if (!title.equals("") || from != null || to != null) {
            builder.append(" WHERE ");
        }
        if (!title.equals("")) {
            builder.append("n.title = :title ");
        }
        if (from != null) {
            if (!title.equals("")) {
                builder.append(" and ");
            }
            builder.append("date >= :from ");
        }
        if (to != null) {
            if (!title.equals("") || from != null) {
                builder.append(" and ");
            }
            builder.append("date <= :to");
        }

        Query query = getSession().createQuery(builder.toString());

        if (!title.equals("")) {
            query.setParameter("title", title);
        }
        if (from != null) {
            query.setParameter("from", from);
        }
        if (to != null) {
            query.setParameter("to", to);
        }

        return query.list();
    }
}
