package com.brainstorm.repository;

import com.brainstorm.domain.Category;
import com.brainstorm.domain.Idea;
import com.brainstorm.domain.Voter;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class IdeaRepositoryTest {

    @Autowired
    IdeaRepository ideaRepository;

    @Test
    void save() {
        String testTitle = "test title";
        String testDescription = "test description";

        String testCategory = "test category";
        List<Category> categories = List.of(new Category(ObjectId.get(), testCategory));

        String testName = "test name";
        List<Voter> voters = List.of(new Voter(ObjectId.get(), testName));

        Idea idea = ideaRepository.save(new Idea(testTitle, testDescription, categories, voters));

        assertNotNull(idea.getId());
        assertEquals(testTitle, idea.getTitle());
        assertEquals(testDescription, idea.getDescription());
        assertEquals(testCategory, idea.getCategories().get(0).getCategory());
        assertEquals(testName, idea.getVoters().get(0).getName());
    }
}