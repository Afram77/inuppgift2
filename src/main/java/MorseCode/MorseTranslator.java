package MorseCode;

import java.util.HashMap;

public class MorseTranslator {

    // Skapar en hashmap som kopplar bokstav till morsekod
    HashMap<Character, String> morseCodes = new HashMap<>();
    // Skapar en hashmap som kopplar morsekod till bokstav
    HashMap<String, Character> letters = new HashMap<>();

    // Konstruktorn för MorseTranslator
    public MorseTranslator() {

        // Skapar en array för bokstäverna A till Z
        char[] text = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        // Skapar en array för morsekoderna som bokstäverna ovan
        String[] morsecodes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        // Går igenom arrayen med bokstäver, en i taget
        for (int i = 0; i < text.length; i++) {
            // Lägger in bokstaven och dess morsekod i hashmap
            morseCodes.put(text[i], morsecodes[i]);
            // Lägger in morsekoden och dess bokstav i den omvända hashmap
            letters.put(morsecodes[i], text[i]);
        }
    }
    // Översätter en text till morsekod
    public String textToMorse(String text) {

        // Skapar en variabel där morsekoderna sparas
        String result = "";

        // Går igenom texten, en bokstav i taget
        for (int i = 0; i < text.length(); i++) {

            // Hämtar bokstaven från texten (och gör den till stor bokstav)
            char letter = Character.toUpperCase(text.charAt(i));

            // Om bokstaven finns i kartan hämtar vi dess morsekod
            if (morseCodes.containsKey(letter)) {
                // Lägger till bokstavens morsekod och ett mellanslag
                result += morseCodes.get(letter) + " ";

                // Mellanslag i användarens text, gå vidare
            } else if (letter == ' ') {

                // Felmeddelande vid fel tecken - Ej bokstav A-Z
            } else {
                return "\nInvalid input: the character " + letter + " cannot be translated.";
            }
        }
        // Tar bort mellanslaget och skickar resultatet
        return result.trim();
    }
    // Översätter morsekod till text
    public String morseToText(String morse) {

        // Skapar en vriabel där bokstäver sparas
        String result = "";

        // Splittar morsekoden vid mellanslagen och sparar koden i en array
        String[] codes = morse.split(" ");

        // Går igenom morsekoden, en i taget
        for (int i = 0; i < codes.length; i++) {

            // Om koden finns i kartan lägger vi till motsvarande bokstav
            if (letters.containsKey(codes[i])) {
                // Lägger till bokstaven som hör till morsekoden
                result += letters.get(codes[i]);

                // Om koden saknas returneras ett felmeddelande
            } else {
                return "\nInvalid input: Morse Code " + codes[i] + " does not exist.";
            }
        }
        //Skickar resultatet
        return result;
    }
}