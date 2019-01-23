package com.company;

import java.io.Serializable;

public class Benutzer implements Serializable {//beutzerklasse ist sommit serialisierbar/ speicherbar
   private String benutzername, password;


    public Benutzer(String benutzername, String password){
        this.benutzername= benutzername;
        this.password= password;
        System.out.println(this.toString());
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Neuer Benutzer registriet. Benutzer = "+ benutzername+ "Passwort= "+password;
    }

}
