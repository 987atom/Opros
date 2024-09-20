package com.oprosWeb.web.repositories;

import com.oprosWeb.web.models.VoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<VoteModel, Long> {
}
