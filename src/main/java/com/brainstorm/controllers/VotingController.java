package com.brainstorm.controllers;

import com.brainstorm.domain.Idea;
import com.brainstorm.repository.IdeaRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VotingController {

    private IdeaRepository ideaRepository;

    @PostMapping(path = "/api/voteForIdea")
    @ResponseBody
    public ResponseEntity voteForIdea(@RequestParam("ideaId") ObjectId ideaId,
                                      @RequestParam("user") String user,
                                      @RequestParam("thumbUp") boolean thumbUp) {

        Idea idea = ideaRepository.findById(ideaId).orElseThrow();
        List<String> thumbUpVoters = idea.getThumbUp();
        List<String> thumbDownVoters = idea.getThumbDown();

        // if it user is voting for the first time
        if (!thumbUpVoters.contains(user) && !thumbDownVoters.contains(user)) {
            if (thumbUp) {
                thumbUpVoters.add(user);
            } else {
                thumbDownVoters.add(user);
            }
        } else {
            // if user already voted and want to change the decision
            if (thumbUp) {
                thumbDownVoters.remove(user);
                thumbUpVoters.add(user);
            } else {
                thumbUpVoters.remove(user);
                thumbDownVoters.add(user);
            }
        }

        ideaRepository.save(idea);

        return new ResponseEntity(HttpStatus.OK);
    }
}
