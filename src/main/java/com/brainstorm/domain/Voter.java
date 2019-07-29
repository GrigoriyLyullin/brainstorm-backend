package com.brainstorm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "voter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voter {

    @Id
    private ObjectId id;

    @Field(value = "name")
    private String name;

    public Voter(String name) {
        this.name = name;
    }
}
