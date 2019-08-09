package com.brainstorm.repository;

import com.brainstorm.domain.Category;
import com.brainstorm.domain.Idea;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class IdeaRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    IdeaRepository ideaRepository;

    @Test
    void save() {
        String testTitle = "test title";
        String testDescription = "test description";

        String testCategory = "test category";
        Category category = new Category(ObjectId.get(), testCategory);

        categoryRepository.save(category);

        Idea idea = ideaRepository.save(new Idea(testTitle, testDescription, Collections.singleton(category)));

        assertNotNull(idea.getId());
        assertEquals(testTitle, idea.getTitle());
        assertEquals(testDescription, idea.getDescription());
        assertEquals(testCategory, idea.getCategories().iterator().next().getCategory());
    }
}