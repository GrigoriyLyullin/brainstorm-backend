package com.brainstorm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

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

    @Field(value = "category")
    private String category;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Field(value = "thumb_up")
    private long thumbUp;

    @Field(value = "thumb_down")
    private long thumbDown;

    //    @DBRef
//    private List<Voter> voters;

//    public Idea(String title, String description, Category category, List<Voter> voters) {
//        this.title = title;
//        this.description = description;
//        this.category = category;
//        this.voters = voters;
//    }
}
