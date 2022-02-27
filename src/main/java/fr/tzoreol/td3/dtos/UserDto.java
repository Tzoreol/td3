package fr.tzoreol.td3.dtos;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("user")
@SessionScoped
public class UserDto implements Serializable {
    private String login;
    private String password;
    private boolean connected;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String doLogin() {
        if(this.login.equals("Tzoreol") && this.password.equals("Password0!")) {
            this.connected = true;
        }

        return "index.jsf";
    }
}
