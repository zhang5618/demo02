package com.kgc.pojo;

import java.util.Date;

public class Reply {
    private int id;
    private int invid;
    private String content;
    private String author ;
    private Date createdate;

    public String toString1() {
        return invid+","+content+","+author+","+createdate;
    }
    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", invid=" + invid +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvid() {
        return invid;
    }

    public void setInvid(int invid) {
        this.invid = invid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
