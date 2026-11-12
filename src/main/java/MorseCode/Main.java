package MorseCode;

import java.util.Scanner;

// Skapar klassen Main
public class Main {

    // Startpunkt för programmet
    public static void main(String[] args) {

        // Tar emot text från användaren
        Scanner scanner = new Scanner(System.in);

        // Skapar en text variabel för användarens val
        String option = "";

        // Fortsätter fråga tills användaren skriver 1 eller 2
        while (!option.equals("1") && !option.equals("2")) {
            System.out.println("\nChoose what you want to translate:");
            System.out.println("1. Text to Morse code");
            System.out.println("2. Morse code to text");

            // Sparar användarens val
            option = scanner.nextLine();

            // Kontrollerar om valet är ogiltigt
            if (!option.equals("1") && !option.equals("2")) {
                System.out.println("\nInvalid choice. Try again.");
            }
        }
        // Skapar en tom variabel som sparar användarens inmatning
        String input = "";

        // Upprepar loopen om inmatningen är tom
        while (input.trim().isEmpty()) {
            // Om användaren valt 1
            if (option.equals("1")) {
                System.out.println("Enter the text to be translated into Morse code:");
                // Om användaren valt 2
            } else {
                System.out.println("Enter the Morse code to be translated into text:");
            }
            // Läser in användarens svar och sparar det
            input = scanner.nextLine();

            // Kontrollerar om inmatningen är tom
            if (input.trim().isEmpty()) {
                System.out.println("The input cannot be empty. Please try again.");
            }
        }
        // Skickar valet och inmatningen till getOption
        System.out.println(getOption(option, input));
    }
    // Hanterar användarens menyval, text och morsekod
    public static String getOption(String option, String input) {

        // Skapar ett objekt
        MorseTranslator translator = new MorseTranslator();

        // Om inmatningen är tom, skicka felmeddelande
        if (input.trim().isEmpty()) {
            return "The input must not be empty.";
        }
        // Om användaren valde 1
        if (option.equals("1")) {
            // Skickar inmatningen till textToMorse och returnerar den översatta texten
            return translator.textToMorse(input);

            // Om användaren valde 2
        } else if (option.equals("2")) {
            // Skickar inmatningen till morseToText och returnerar den översatta texten
            return translator.morseToText(input);

            // Visar ett felmeddelande
        } else {
            return "Invalid choice. Select 1 or 2.";
        }
    }
}