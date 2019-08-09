package com.brainstorm.controllers;

import com.brainstorm.dto.CategoryDTO;
import com.brainstorm.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CategorySearchController {

    private CategoryRepository categoryRepository;

    @GetMapping(path = "/api/findCategoriesByName")
    public Set<CategoryDTO> findCategoriesByName(@RequestParam("name") String name) {
        return categoryRepository.findTop5ByCategoryContainingIgnoreCase(name).stream()
                .map(c -> new CategoryDTO(c.getId().toString(), c.getCategory())).collect(Collectors.toSet());
    }
}
