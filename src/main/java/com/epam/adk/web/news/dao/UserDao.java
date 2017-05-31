package com.epam.adk.web.news.dao;

import com.epam.adk.web.news.model.User;

/**
 * TODO: Comment
 * <p>
 * Created on 5/31/2017.
 *
 * @author Kaikenov Adilkhan
 */
public interface UserDao {

    User findByAuth(String login, String password);

}
