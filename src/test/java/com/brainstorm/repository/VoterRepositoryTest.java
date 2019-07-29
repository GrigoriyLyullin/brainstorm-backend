package com.brainstorm.repository;

import com.brainstorm.domain.Voter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
class VoterRepositoryTest {

    @Autowired
    VoterRepository voterRepository;

    @Test
    void save() {
        String testName = "test name";
        Voter voter = voterRepository.save(new Voter(testName));

        assertNotNull(voter.getId());
        assertEquals(testName, voter.getName());
    }
}