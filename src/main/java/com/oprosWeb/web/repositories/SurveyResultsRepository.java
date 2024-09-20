package com.oprosWeb.web.repositories;

import com.oprosWeb.web.models.SurveyResultsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyResultsRepository extends JpaRepository<SurveyResultsModel, Long> {
}
