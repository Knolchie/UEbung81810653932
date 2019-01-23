package com.company;

import javax.swing.*;
import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Benutzer> benutzerListe = new ArrayList<>();

    public static void main(String[] args) {

        //1. Prüfen ob benutzer vorhanden
        //2 wenn vorhanden, reinladen
        //3. ansonsten neu erstellen


        if (FileHandler.benutzerDatei.exists()) {
            benutzerListe.add(FileHandler.loadUser());//liefert gespeicherten benutzer und added in loist
            System.out.println(benutzerListe.size());
        }else {

            JOptionPane.showMessageDialog(null, "Noch kein Benutzer vorhanden, bitte registrieren!");

            String bn = JOptionPane.showInputDialog("Benutzername aussuchen");// reg
            String pw = JOptionPane.showInputDialog("Passwort aussuchen");

            Benutzer eins = new Benutzer(bn, Crypto.verschluesselung(pw));
            benutzerListe.add(eins);
            FileHandler.saveUser(eins);
        }

        JOptionPane.showMessageDialog(null, "Login: ");

        String logbn = JOptionPane.showInputDialog("Benutzername eingeben"); //
        String logpw = JOptionPane.showInputDialog("Passwort eingeben");

        System.out.println(benutzerListe.get(0).getBenutzername() + " (verschlüsselt) = " + benutzerListe.get(0).getPassword() + ", entschlüsselt = " + Crypto.entschluesselung(benutzerListe.get(0).getPassword()));

        for (int i = 0; i < benutzerListe.size(); i++) {
            if (logbn.equals(benutzerListe.get(i).getBenutzername()) && (logpw.equals(Crypto.entschluesselung(benutzerListe.get(i).getPassword())))) {
                JOptionPane.showMessageDialog(null, "Gratuliere, erfolgreich angemeldet, dein Password lautet" + " Ich liebe Kekse");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "doesnt work");
                break;
            }
        }
    }
}
