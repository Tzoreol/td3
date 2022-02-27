package fr.tzoreol.td3.ejbs.impl;

import fr.tzoreol.td3.dtos.VoteDto;
import fr.tzoreol.td3.ejbs.Eurovision;
import fr.tzoreol.td3.enums.Country;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EurovisionBean implements Eurovision {
    private static final int WINNER_POINTS = 12;
    private static final int RUNNER_UP_POINTS = 10;
    @Override
    public List<VoteDto> addVote(Country winner, List<VoteDto> actualVotes) {
        VoteDto voteToAdd = new VoteDto();
        if(winner == Country.FRANCE) {
            voteToAdd.setWinner(Country.FRANCE);
            voteToAdd.setRunnerUp(Country.ITALY);
        } else {
            voteToAdd.setWinner(Country.ITALY);
            voteToAdd.setRunnerUp(Country.FRANCE);
        }

        actualVotes.add(voteToAdd);
        return actualVotes;
    }

    @Override
    public Country getEurovisionWinner(List<VoteDto> finalVote) {
        int franceTotal = 0;
        int italyTotal = 0;

        for(VoteDto vote : finalVote) {
            if(vote.getWinner() == Country.FRANCE) {
                franceTotal += WINNER_POINTS;
                italyTotal += RUNNER_UP_POINTS;
            } else {
                italyTotal += WINNER_POINTS;
                franceTotal += RUNNER_UP_POINTS;
            }
        }

        if(franceTotal > italyTotal) {
            return Country.FRANCE;
        } else if (italyTotal > franceTotal) {
            return Country.ITALY;
        } else {
            return null;
        }
    }
}
