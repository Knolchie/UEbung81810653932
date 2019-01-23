package com.company;

import java.io.*;

public class FileHandler {

    public static File benutzerDatei = new File("benutzer.txt"); //file erstellt

    public static  void saveUser (Benutzer b ) // übergabe benutzer aus benutzerklasse
    {

        try {
            FileOutputStream fos = new FileOutputStream(benutzerDatei);//erstellt file
            ObjectOutputStream oos = new ObjectOutputStream(fos);//schreibt in file

            oos.writeObject(b);// schreibt benutzer in datei ein
            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();// schreibt exception
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }


    }
    public static Benutzer loadUser() {
        try {
            FileInputStream fis = new FileInputStream(benutzerDatei);
            ObjectInputStream ois = new ObjectInputStream(fis);

            return (Benutzer) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            e.getException();
        }
        return null;
    }
}
