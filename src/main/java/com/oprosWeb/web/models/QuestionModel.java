package com.oprosWeb.web.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questions")
public class QuestionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private SurveyModel survey;

    private String questionText;

    @OneToMany(mappedBy = "question")
    private List<ChoiceModel> choices;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public SurveyModel getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyModel survey) {
        this.survey = survey;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<ChoiceModel> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceModel> choices) {
        this.choices = choices;
    }
}
