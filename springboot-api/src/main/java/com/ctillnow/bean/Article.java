package com.ctillnow.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caiping on 2019/10/14.
 */
public class Article implements Serializable{

    private Integer id;
    private String title;
    private String content;
    private String digest;
    private String author;
    private Date createTime;
    private Date submitTime;
    private Date lastUpdateTime;
    private int cityId;
    private boolean readable;
    private Long readCount;
    private boolean isDeleted;

    public  Article(){};

    public Article(Integer id, String title, String content, String digest, String author, Date createTime, Date submitTime, Date lastUpdateTime, int cityId, boolean readable, Long readCount, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.digest = digest;
        this.author = author;
        this.createTime = createTime;
        this.submitTime = submitTime;
        this.lastUpdateTime = lastUpdateTime;
        this.cityId = cityId;
        this.readable = readable;
        this.readCount = readCount;
        this.isDeleted = isDeleted;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public boolean isReadable() {
        return readable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", digest='" + digest + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", submitTime=" + submitTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", cityId=" + cityId +
                ", readable=" + readable +
                ", readCount=" + readCount +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

