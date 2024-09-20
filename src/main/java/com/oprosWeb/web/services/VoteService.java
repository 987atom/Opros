package com.oprosWeb.web.services;

import com.oprosWeb.web.models.VoteModel;

import java.util.List;

public interface VoteService {
    VoteModel saveVote(VoteModel vote);
    VoteModel getVoteById(Long voteId);
    List<VoteModel> getAllVotes();
    VoteModel updateVote(VoteModel vote);
    void deleteVote(Long voteId);
}
