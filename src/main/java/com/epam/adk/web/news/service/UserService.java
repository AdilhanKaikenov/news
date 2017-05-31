package com.epam.adk.web.news.service;

import com.epam.adk.web.news.dao.UserDao;
import com.epam.adk.web.news.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Comment
 * <p>
 * Created on 5/31/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Service
@Transactional
public class UserService {

    @Autowired
    @Qualifier("HibernateJpaUserDao")
    private UserDao userDao;

    public User getUserByAuth(String login, String password) {
        return userDao.findByAuth(login, password);
    }
}
