package pl.lukaszprasek.FirstApp.controllers.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PacientForm {
    @NotEmpty
    @Size(max = 6)

    private int cardNumber;
    @NotEmpty
    @Size(max = 6)
    @Pattern(regexp="[0-9]{6}")
    private String password;

    public PacientForm() {
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
