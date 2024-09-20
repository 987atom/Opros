package com.oprosWeb.web.services.impl;

import com.oprosWeb.web.models.VoteModel;
import com.oprosWeb.web.repositories.VoteRepository;
import com.oprosWeb.web.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public VoteModel saveVote(VoteModel vote) {
        return voteRepository.save(vote);
    }

    @Override
    public VoteModel getVoteById(Long voteId) {
        return voteRepository.findById(voteId).orElse(null);
    }

    @Override
    public List<VoteModel> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public VoteModel updateVote(VoteModel vote) {
        return voteRepository.save(vote);
    }

    @Override
    public void deleteVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }
}
