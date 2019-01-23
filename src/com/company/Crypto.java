package com.company;

public class Crypto {
    static String container= "abcdefghijklmnopqrstuvwxyz000";

    public static String verschluesselung(String geheim){
        StringBuilder ergebnis = new StringBuilder();

        for (int i= 0; i<geheim.length();i++) //läuft so lange wie geheimnis
        {
            /** gib den i-ten buchstaben des gesuchten wortes zurück*/
            char b = geheim.charAt(i);//ite position geheimwort

            for(int j=0; j<container.length();j++)
            {
                if(container.charAt(j) == b)
                //sucht den buchstaben und gibt den rechts davon zurück
                {
                    //Fügt pro durchlauf einen geheimen buchstaben hinzu,
                    //bis der string fertig ist
                    ergebnis.append(container.charAt(j+2));
                }
            }
        }
        return ergebnis.toString();
    }

    /**
     *
     * Gegenteil von oben
     *
     */
    public static String entschluesselung(String geheim) {
        StringBuilder ergebnis = new StringBuilder();

        for(int i = 0; i < geheim.length(); i++){
            char b = geheim.charAt(i);

            for (int j = 0; j < container.length(); j++){
                if (container.charAt(j) == b){
                    ergebnis.append(container.charAt(j-2));
                }
            }
        }

        return ergebnis.toString();
    }
}
