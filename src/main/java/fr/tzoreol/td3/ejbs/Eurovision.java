package fr.tzoreol.td3.ejbs;

import fr.tzoreol.td3.dtos.VoteDto;
import fr.tzoreol.td3.enums.Country;

import javax.ejb.Local;
import java.util.List;

@Local
public interface Eurovision {
    List<VoteDto> addVote(Country winner, List<VoteDto> actualVotes);
    Country getEurovisionWinner(List<VoteDto> finalVotes);
}
