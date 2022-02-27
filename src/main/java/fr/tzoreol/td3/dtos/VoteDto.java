package fr.tzoreol.td3.dtos;
import fr.tzoreol.td3.enums.Country;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("vote")
@RequestScoped
public class VoteDto implements Serializable {
    private Country winner;
    private Country runnerUp;

    public Country getWinner() {
        return winner;
    }

    public void setWinner(Country winner) {
        this.winner = winner;
    }

    public Country getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(Country runnerUp) {
        this.runnerUp = runnerUp;
    }
}
