package com.epam.adk.web.news.controller;

import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: Comment
 * <p>
 * Created on 5/23/2017.
 *
 * @author Kaikenov Adilkhan
 */
@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NewsRestController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<News> getNews(@PathVariable String id) {
        News news = newsService.readNews(Integer.parseInt(id));
        if (news == null) {
            return new ResponseEntity<>(news, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(news, HttpStatus.OK);
    }


}
