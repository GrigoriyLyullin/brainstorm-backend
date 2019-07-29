package com.brainstorm.repository;

import com.brainstorm.domain.Voter;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface VoterRepository extends PagingAndSortingRepository<Voter, ObjectId> {
}
