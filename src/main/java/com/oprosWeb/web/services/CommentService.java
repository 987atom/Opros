package com.oprosWeb.web.services;

import com.oprosWeb.web.models.CommentModel;

import java.util.List;

public interface CommentService {
    CommentModel saveComment(CommentModel comment);
    CommentModel getCommentById(Long commentId);
    List<CommentModel> getAllComments();
    CommentModel updateComment(CommentModel comment);
    void deleteComment(Long commentId);

    List<CommentModel> getAllCommentsByVote(Long voteId);
}
