package com.brainstorm.repository;

import com.brainstorm.domain.Idea;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface IdeaRepository extends PagingAndSortingRepository<Idea, ObjectId> {
}
