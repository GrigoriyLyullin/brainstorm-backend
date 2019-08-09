package com.brainstorm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "idea")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Idea {

    @Id
    private ObjectId id;

    @Field(value = "title")
    private String title;

    @Field(value = "description")
    private String description;

    @DBRef
    private List<Category> categories;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Field(value = "thumb_up")
    private List<String> thumbUp;

    @Field(value = "thumb_down")
    private List<String> thumbDown;

    @Field(value = "picture")
    private String picture;

    public Idea(String title, String description, List<Category> categories) {
        this.title = title;
        this.description = description;
        this.categories = categories;
    }
}
