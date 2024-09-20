package com.oprosWeb.web.services.impl;

import com.oprosWeb.web.models.CommentModel;
import com.oprosWeb.web.repositories.CommentRepository;
import com.oprosWeb.web.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentModel> getAllCommentsByVote(Long voteId) {
        return commentRepository.findByVoteVoteId(voteId);
    }
    @Override
    public CommentModel saveComment(CommentModel comment) {
        return commentRepository.save(comment);
    }

    @Override
    public CommentModel getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public List<CommentModel> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public CommentModel updateComment(CommentModel comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
