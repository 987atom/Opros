package com.oprosWeb.web.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "survey_results")
public class SurveyResultsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private SurveyModel survey;

    @OneToMany(mappedBy = "surveyResults")
    private List<VoteModel> votes;

    private Long totalVotes;

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public SurveyModel getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyModel survey) {
        this.survey = survey;
    }

    public List<VoteModel> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteModel> votes) {
        this.votes = votes;
    }

    public Long getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Long totalVotes) {
        this.totalVotes = totalVotes;
    }
}
