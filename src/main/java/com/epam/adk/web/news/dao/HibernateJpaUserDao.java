package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/31/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Repository
@Qualifier("HibernateJpaUserDao")
public class HibernateJpaUserDao implements UserDao {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private static final String HQL_QUERY_SELECT_USER_BY_AUTH = "from User u where u.login = :login and u.password = :password";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByAuth(String login, String password) {
        Query query = sessionFactory.getCurrentSession().createQuery(HQL_QUERY_SELECT_USER_BY_AUTH);
        query.setParameter(LOGIN, login);
        query.setParameter(PASSWORD, password);
        List<User> userList = query.list();
        return userList.isEmpty() ? null : userList.iterator().next();
    }
}
