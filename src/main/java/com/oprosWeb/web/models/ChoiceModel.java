package com.oprosWeb.web.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "choices")
public class ChoiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long choiceId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionModel question;

    private String choiceText;

    @OneToMany(mappedBy = "choice")
    private List<VoteModel> votes;

    public Long getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(Long choiceId) {
        this.choiceId = choiceId;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public List<VoteModel> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteModel> votes) {
        this.votes = votes;
    }
}
