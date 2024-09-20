package com.oprosWeb.web.repositories;

import com.oprosWeb.web.models.SurveyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyModel, Long> {
}
