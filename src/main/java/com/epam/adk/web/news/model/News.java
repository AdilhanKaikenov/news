package com.epam.adk.web.news.model;

import java.util.Date;

/**
 * TODO: Comment
 *
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class News extends BaseEntity {

    private String title;
    private Date date;
    private String brief;
    private String content;

    public News() {
    }

    public News(String title, Date date, String brief, String content) {
        this.title = title;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }

    public News(long id, String title, Date date, String brief, String content) {
        super(id);
        this.title = title;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
