package jp.xkzm.millibrary.entity;

import com.alibaba.fastjson2.annotation.JSONField;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Date;

@Entity
@Data
@Table(name = "literature")
public class Literature {

    @JSONField(name = "isbn")
    @Id
    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @JSONField(name = "author")
    @Column(name = "author")
    private String author;

    @JSONField(name = "title")
    @Column(name = "title")
    private String title;

    @JSONField(name = "description")
    @Column(name = "description")
    private String description;

    @JSONField(name = "image")
    @Column(name = "image")
    private String image;

    @JSONField(name = "updated")
    @Column(name = "updated")
    private Date updated;

    @JSONField(name = "created")
    @Column(name = "created")
    private Date created;

    @JSONField(name = "deleted")
    @Column(name = "deleted")
    private Date deleted;


    public Literature() { }

    public Literature(
            String isbn,
            String author,
            String title,
            String description,
            String imageURL,
            Date   created,
            Date   updated,
            Date   deleted
    ){

        this.isbn        = isbn;
        this.author      = author;
        this.title       = title;
        this.description = description;
        try {

            this.image = URI.create(imageURL).toURL().toString();

        } catch (MalformedURLException e) {

            this.image    = "";
            e.printStackTrace();

        }

        this.created = created;
        this.updated = updated;
        this.deleted = deleted;

    }
}
