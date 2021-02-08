package com.prostosasha.pamiatkajavista.models;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "page_name")
    private String pageName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "comment")
    private String comment;

    public Comment() {
    }

    public Comment(String pageName, String userName, String comment) {
        this.pageName = pageName;
        this.userName = userName;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", pageName='" + pageName + '\'' +
                ", userName='" + userName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
