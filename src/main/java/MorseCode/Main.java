package MorseCode;

import java.util.Scanner;

// Skapar klassen Main
public class Main {

    // Startpunkt för programmet
    public static void main(String[] args) {

        // Tar emot text från användaren
        Scanner scanner = new Scanner(System.in);

        // Skapar en text variabel för användarens val
        String val = "";

        // Fortsätter fråga tills användaren skriver 1 eller 2
        while (!val.equals("1") && !val.equals("2")) {
            System.out.println("Välj vad du vill översätta:");
            System.out.println("1. Text till morsekod");
            System.out.println("2. Morsekod till text");

            // Sparar användarens val
            val = scanner.nextLine();

            // Kontrollerar om valet är ogiltigt
            if (!val.equals("1") && !val.equals("2")) {
                System.out.println("Ogiltigt val. Försök igen.\n");
            }
        }
        // Skapar en tom variabel som sparar användarens inmatning
        String input = "";

        // Upprepar loopen om inmatningen är tom eller bara innehåller mellanslag
        while (input.trim().isEmpty()) {
            // Om användaren valt 1
            if (val.equals("1")) {
                System.out.println("Skriv texten som ska översättas till morsekod:");
                // Om användaren valt 2
            } else {
                System.out.println("Skriv morsekoden som ska översättas till text:");
            }
            // Läser in användarens svar och sparar det
            input = scanner.nextLine();

            // Kontrollerar om inmatningen är tom
            if (input.trim().isEmpty()) {
                System.out.println("Inmatningen får inte vara tom. Försök igen.");
            }
        }
        // Skickar valet och inmatningen till hanteraVal
        System.out.println(hanteraVal(val, input));
    }
    // Hanterar användarens menyval, text och morsekod
    public static String hanteraVal(String val, String inmatning) {

        // Skapar ett objekt
        MorseTranslator translator = new MorseTranslator();

        // Om inmatningen är tom, skicka felmeddelande
        if (inmatning.trim().isEmpty()) {
            return "Inmatningen får inte vara tom.";
        }
        // Om användaren valde 1
        if (val.equals("1")) {
            // Skickar inmatningen till textToMorse och returnerar den översatta texten
            return translator.textToMorse(inmatning);

            // Om användaren valde 2
        } else if (val.equals("2")) {
            // Skickar inmatningen till morseToText och returnerar den översatta texten
            return translator.morseToText(inmatning);

            // Visar ett felmeddelande
        } else {
            return "Ogiltigt val. Välj 1 eller 2.";
        }
    }
}