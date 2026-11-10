package MorseCode;

import java.util.HashMap;

public class MorseTranslator {

    // Skapar en hashmap som kopplar bokstav till morsekod
    HashMap<Character, String> morseKoder = new HashMap<>();
    // Skapar en hashmap som kopplar morsekod till bokstav
    HashMap<String, Character> bokstaver = new HashMap<>();

    // Konstruktorn för MorseTranslator
    public MorseTranslator() {

        // Skapar en array för bokstäverna A till Z
        char[] text = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        // Skapar en array för morsekoderna som bokstäverna ovan
        String[] morsekoder = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        // Går igenom arrayen med bokstäver, en i taget
        for (int i = 0; i < text.length; i++) {
            // Lägger in bokstaven och dess morsekod i hashmap
            morseKoder.put(text[i], morsekoder[i]);
            // Lägger in morsekoden och dess bokstav i den omvända hashmap
            bokstaver.put(morsekoder[i], text[i]);
        }
    }
    // Översätter en text till morsekod
    public String textToMorse(String text) {

        // Skapar en variabel där morsekoderna sparas
        String resultat = "";

        // Går igenom texten, en bokstav i taget
        for (int i = 0; i < text.length(); i++) {

            // Hämtar bokstaven från texten (och gör den till stor bokstav)
            char bokstav = Character.toUpperCase(text.charAt(i));

            // Om bokstaven finns i kartan hämtar vi dess morsekod
            if (morseKoder.containsKey(bokstav)) {
                // Lägger till bokstavens morsekod och ett mellanslag
                resultat += morseKoder.get(bokstav) + " ";

                // Mellanslag i användarens text, gå vidare
            } else if (bokstav == ' ') {

                // Felmeddelande vid fel tecken - Ej bokstav A-Z
            } else {
                return "Fel: tecknet " + bokstav + " kan inte översättas.";
            }
        }
        // Tar bort mellanslaget och skickar resultatet
        return resultat.trim();
    }
    // Översätter morsekod till text
    public String morseToText(String morse) {

        // Skapar en vriabel där bokstäver sparas
        String resultat = "";

        // Splittar morsekoden vid mellanslagen och sparar koden i en array
        String[] koder = morse.split(" ");

        // Går igenom morsekoden, en i taget
        for (int i = 0; i < koder.length; i++) {

            // Om koden finns i kartan lägger vi till motsvarande bokstav
            if(bokstaver.containsKey(koder[i])) {
                // Lägger till bokstaven som hör till morsekoden
                resultat += bokstaver.get(koder[i]);

                // Om koden saknas returneras ett felmeddelande
            } else {
                return "Fel: morsekoden " + koder[i] + " finns inte.";
            }
        }
        //Skickar resultatet
        return resultat;
    }
}