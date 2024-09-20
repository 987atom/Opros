package com.oprosWeb.web.repositories;

import com.oprosWeb.web.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    List<CommentModel> findByVoteVoteId(Long voteId);
}
