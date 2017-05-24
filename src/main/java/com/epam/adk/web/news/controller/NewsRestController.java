package com.epam.adk.web.news.controller;

import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/get/", method = RequestMethod.GET)
    public ResponseEntity<List<News>> getNewsList() {

        List<News> newsList = newsService.readAllNews();

        if (newsList.isEmpty()) {
            return new ResponseEntity<>(newsList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<News> createNews(@RequestBody News news) {

        if (news.getId() != 0) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        newsService.addNews(news);

        return new ResponseEntity<>(news, HttpStatus.CREATED);
    }
}
