package com.brainstorm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    @DBRef
    private List<Voter> voters;

    public Idea(String title, String description, List<Category> categories, List<Voter> voters) {
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.voters = voters;
    }
}
