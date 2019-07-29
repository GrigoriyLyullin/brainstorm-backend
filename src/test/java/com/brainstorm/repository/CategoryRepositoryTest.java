package com.brainstorm.repository;

import com.brainstorm.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void save() {
        String testCategory = "test category";
        Category category = categoryRepository.save(new Category(testCategory));

        assertNotNull(category.getId());
        assertEquals(testCategory, category.getCategory());
    }
}