package com.epam.adk.web.news.form;

import com.epam.adk.web.news.model.News;
import org.apache.struts.validator.ValidatorForm;

/**
 * TODO: Comment
 * <p>
 * Created on 5/17/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class NewsForm extends ValidatorForm {

    private News news = new News();
    private String strDate;

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
}
