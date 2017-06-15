package com.epam.adk.web.news.soap;

import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/25/2017.
 *
 * @author Kaikenov Adilkhan
 */
@WebService(endpointInterface = "com.epam.adk.web.news.soap.SoapWebService", serviceName = "News")
public class NewsSoapWebService implements SoapWebService<News> {

    @Autowired
    private NewsService newsService;

    @WebMethod
    @Override
    public News create(News news) {
        return newsService.saveOrEditNews(news);
    }

    @WebMethod
    @Override
    public News read(int id) {
        return newsService.readNews(id);
    }

    @WebMethod
    @Override
    public News update(News news) {
        newsService.saveOrEditNews(news);
        return news;
    }

    @WebMethod
    @Override
    public void delete(int id) {
        newsService.deleteNews(id);
    }

    @WebMethod
    @Override
    public void deleteAll(List<Integer> idList) {
        List<News> newsList = new ArrayList<>();
        for (Integer id : idList) {
            newsList.add(newsService.readNews(id));
        }
        newsService.deleteNewsList(newsList);
    }
}
