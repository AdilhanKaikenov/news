package com.epam.adk.web.news.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * TODO: Comment
 *
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
@NamedQueries({
        @NamedQuery(name = "News.readById", query = "FROM News news WHERE news.id=:id"),
        @NamedQuery(name = "News.readAll", query = "FROM News order by date desc"),
        @NamedQuery(name = "News.deleteById", query = "DELETE FROM News news WHERE news.id = :id"),
        @NamedQuery(name = "News.deleteList", query = "DELETE FROM News news WHERE news.id = :idList"),
        @NamedQuery(name = "News.countRows", query = "select count(*) FROM News")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "News.update", query = "UPDATE News SET title = :title, datetime = :datetime," +
                "brief = :brief, content = :content WHERE id = :id")
})
@XmlRootElement(name = "news")
@Entity
@Table(name = "NEWS")
public class News extends BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_SEQ")
    @SequenceGenerator(name = "NEWS_SEQ", sequenceName = "NEWS_SEQ", allocationSize = 1)
    private int id;
    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATETIME")
    private Date date = new Date();

    @Column(name = "BRIEF")
    private String brief;

    @Column(name = "CONTENT")
    private String content;

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
