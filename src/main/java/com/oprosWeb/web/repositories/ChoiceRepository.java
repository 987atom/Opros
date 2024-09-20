package com.oprosWeb.web.repositories;

import com.oprosWeb.web.models.ChoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends JpaRepository<ChoiceModel, Long> {
}
