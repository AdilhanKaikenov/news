package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.epam.adk.web.news.util.ConstantHolder.DATE_PROPERTY_NAME;

/**
 * TODO: Comment
 *
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Repository
@Qualifier("HibernateTemplateNewsDao")
public class HibernateTemplateNewsDao implements NewsDao {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public HibernateTemplateNewsDao(HibernateTemplate hibernateTemplate) {
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
    public int save(News news) {
        return (int) hibernateTemplate.save(news);
    }

    @Transactional
    @Override
    public void saveOrUpdate(News news) {
        hibernateTemplate.saveOrUpdate(news);
    }

    @Override
    public void update(News news) {
        hibernateTemplate.update(news);
    }

    @Override
    public List<News> findAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
        return (List<News>)  hibernateTemplate.findByCriteria(criteria.addOrder(Order.desc(DATE_PROPERTY_NAME)));
    }

    @Override
    public void delete(News news) {
        hibernateTemplate.delete(news);
    }

    @Override
    public void deleteAll(List<News> list) {
        hibernateTemplate.deleteAll(list);
    }
}
