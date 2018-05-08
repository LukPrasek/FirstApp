package pl.lukaszprasek.FirstApp.controllers.models;

public class PacientForm {

    private int cardNumber;
    private String password;

    public PacientForm(){}

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
