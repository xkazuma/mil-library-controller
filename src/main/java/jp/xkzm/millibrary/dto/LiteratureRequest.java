package jp.xkzm.millibrary.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LiteratureRequest implements Serializable {

    private String isbn;

    private String author;

    private String title;

    private String description;

    private String image;

    public LiteratureRequest() { }

}