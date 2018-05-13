package pl.lukaszprasek.FirstApp.controllers.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginForm {
    @NotEmpty
    @Size(max=20)
    private String login;

    @NotEmpty
    @Size(max=30)
    @Pattern(regexp=".*")
    private String password;

    public LoginForm() {
    }

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


}
