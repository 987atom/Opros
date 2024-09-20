package com.oprosWeb.web.services.impl;

import com.oprosWeb.web.models.ChoiceModel;
import com.oprosWeb.web.repositories.ChoiceRepository;
import com.oprosWeb.web.services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {

    @Autowired
    private ChoiceRepository choiceRepository;

    @Override
    public ChoiceModel saveChoice(ChoiceModel choice) {
        return choiceRepository.save(choice);
    }

    @Override
    public ChoiceModel getChoiceById(Long choiceId) {
        return choiceRepository.findById(choiceId).orElse(null);
    }

    @Override
    public List<ChoiceModel> getAllChoices() {
        return choiceRepository.findAll();
    }

    @Override
    public ChoiceModel updateChoice(ChoiceModel choice) {
        return choiceRepository.save(choice);
    }

    @Override
    public void deleteChoice(Long choiceId) {
        choiceRepository.deleteById(choiceId);
    }
}
