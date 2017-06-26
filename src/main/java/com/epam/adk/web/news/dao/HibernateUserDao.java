package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.epam.adk.web.news.util.ConstantHolder.LOGIN;
import static com.epam.adk.web.news.util.ConstantHolder.PASSWORD;

/**
 * TODO: Comment
 * <p>
 * Created on 5/31/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Repository
@Qualifier("HibernateUserDao")
public class HibernateUserDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByAuth(String login, String password) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq(LOGIN, login));
        criteria.add(Restrictions.eq(PASSWORD, password));
        List<User> userList = criteria.list();
        return userList.isEmpty() ? null : userList.iterator().next() ;
    }
}
