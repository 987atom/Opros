package com.oprosWeb.web.services;

import com.oprosWeb.web.models.ChoiceModel;

import java.util.List;

public interface ChoiceService {
    ChoiceModel saveChoice(ChoiceModel choice);
    ChoiceModel getChoiceById(Long choiceId);
    List<ChoiceModel> getAllChoices();
    ChoiceModel updateChoice(ChoiceModel choice);
    void deleteChoice(Long choiceId);
}
