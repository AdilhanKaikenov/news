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
    public ResponseEntity<News> getNews(@PathVariable("id") int id) {
        News news = newsService.readNews(id);
        if (news == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<News> updateNews(@RequestBody News news) {
        News targetNews = newsService.readNews(news.getId());

        if (targetNews == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        newsService.updateNews(news);

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<News> deleteNews(@PathVariable("id") int id) {
        News news = newsService.readNews(id);

        if (news == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        newsService.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/", method = RequestMethod.DELETE)
    public ResponseEntity<News> deleteAllNews(@RequestBody List<News> newsList) {

        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        newsService.deleteNewsList(newsList);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
