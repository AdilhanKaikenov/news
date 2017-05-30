package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.News;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    private static final String HQL_QUERY_SELECT_FROM_NEWS_ORDER_BY_DATE_DESC = "FROM News order by date desc";
    private static final String QUERY_SELECT_COUNT_FROM_NEWS = "select count(*) from News";

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int countRowsNumber() {
        return DataAccessUtils.intResult(hibernateTemplate.find(QUERY_SELECT_COUNT_FROM_NEWS));
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
    public List<News> findPaginated(int pageNumber, int pageSize) {
        return hibernateTemplate.execute(new HibernateCallback<List<News>>(){
            @Override
            public List<News> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(HQL_QUERY_SELECT_FROM_NEWS_ORDER_BY_DATE_DESC);
                query.setFirstResult((pageNumber - 1) * pageSize);
                query.setMaxResults(pageSize);
                return query.list();
            }
        });
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

    @Override
    public List<News> findByParameters(String title, Date from, Date to) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
