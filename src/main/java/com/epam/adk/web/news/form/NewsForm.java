package com.epam.adk.web.news.form;

import com.epam.adk.web.news.model.News;
import org.apache.struts.validator.ValidatorForm;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Comment
 * <p>
 * Created on 5/17/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class NewsForm extends ValidatorForm {

    private News news = new News();
    private List<News> newsList = new ArrayList<>();
    private String strDate;
    private int[] selectedNewsIds;

    public NewsForm() {
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public int[] getSelectedNewsIds() {
        return selectedNewsIds;
    }

    public void setSelectedNewsIds(int[] selectedNewsIds) {
        this.selectedNewsIds = selectedNewsIds;
    }
}
