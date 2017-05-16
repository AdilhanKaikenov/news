package com.epam.adk.web.news.model;

/**
 * TODO: Comment
 *
 * Created on 5/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
public abstract class BaseEntity {

    private int id;

    public BaseEntity() {
    }

    public BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
