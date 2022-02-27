package fr.tzoreol.td3.dtos;

import fr.tzoreol.td3.ejbs.Eurovision;
import fr.tzoreol.td3.enums.Country;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("result")
@SessionScoped
public class ResultsDto implements Serializable {
    @EJB
    private Eurovision eurovision;

    private Country winnerCountry;
    private List<VoteDto> votes = new ArrayList<>();

    public Country getWinnerCountry() {
        return winnerCountry;
    }

    public void setWinnerCountry(Country winnerCountry) {
        this.winnerCountry = winnerCountry;
    }

    public List<VoteDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDto> votes) {
        this.votes = votes;
    }

    public void addVote() {
        this.votes = this.eurovision.addVote(this.winnerCountry, this.votes);
    }

    public Country getFinalWinner() {
        return this.eurovision.getEurovisionWinner(this.votes);
    }
}
