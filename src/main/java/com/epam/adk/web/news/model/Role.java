package com.epam.adk.web.news.model;

import javax.persistence.*;

/**
 * TODO: Comment
 * <p>
 * Created on 5/31/2017.
 *
 * @author Kaikenov Adilkhan
 */
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ")
    @SequenceGenerator(name = "ROLES_SEQ", sequenceName = "ROLES_SEQ", allocationSize = 1)
    private int id;
    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
