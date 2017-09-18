package com.jjdev.retrofit.api.client.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jgilson
 */
public class JBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("ID")
    private Integer id;

    @SerializedName("Title")
    private String title;

    @SerializedName("Description")
    private String description;

    @SerializedName("PageCount")
    private Integer pageCount;

    @SerializedName("Excerpt")
    private String Excerpt;

    @SerializedName("PublishDate")
    private Date publishDate;

    public JBook() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getExcerpt() {
        return Excerpt;
    }

    public void setExcerpt(String Excerpt) {
        this.Excerpt = Excerpt;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}
