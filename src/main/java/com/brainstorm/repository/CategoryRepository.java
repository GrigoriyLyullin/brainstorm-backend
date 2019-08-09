package com.brainstorm.repository;

import com.brainstorm.domain.Category;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
public interface CategoryRepository extends PagingAndSortingRepository<Category, ObjectId> {

    List<Category> findTop5ByCategoryContainingIgnoreCase(String category);
}
