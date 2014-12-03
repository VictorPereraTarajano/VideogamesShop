package entities;

import java.io.Serializable;

public class Client implements Serializable {
    
    private String name="", surname="", email="", cardnumber="", mmyy="", cvc="";

    public Client(String name, String surname, String email, String cardnumber, String mmyy, String cvc) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cardnumber = cardnumber;
        this.mmyy = mmyy;
        this.cvc = cvc;
    }

    public Client() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public void setMmyy(String mmyy) {
        this.mmyy = mmyy;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
    
    public String getEmail() {
        return email;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public String getMmyy() {
        return mmyy;
    }

    public String getCvc() {
        return cvc;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
}
