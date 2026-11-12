package MorseCode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Skapar testklassen
public class MorseTranslatorTest {

    @Test
    public void test1LetterToMorse() {

        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String text ="F";

        // Act
        String actual = translator.textToMorse(text);
        String expected ="..-.";

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testWordToMorse() {

        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String text ="HI";

        // Act
        String actual = translator.textToMorse(text);
        String expected =".... ..";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testNumberToMorse() {
        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String text = "1";

        // Act
        String actual = translator.textToMorse(text);
        String expected = "Invalid input: the character 1 cannot be translated.";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testMorseToWord() {
        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String morse =".... ..";

        // Act
        String actual = translator.morseToText(morse);
        String expected ="HI";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testInvalidMorse() {
        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String morse ="......";

        // Act
        String actual = translator.morseToText(morse);
        String expected ="Invalid input: Morse Code ...... does not exist.";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testInvalidCharacter() {
        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String text ="HI!";

        // Act
        String actual = translator.textToMorse(text);
        String expected ="Invalid input: the character ! cannot be translated.";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testMenuVOption1() {
        // Arrange
        String option ="1";
        String input ="HI";

        // Act
        String actual = Main.getOption(option, input);
        String expected =".... ..";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testInvalidMenuOption() {
        // Arrange
        String option ="5";
        String input ="HI";

        // Act
        String actual = Main.getOption(option, input);
        String expected ="Invalid choice. Select 1 or 2.";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testEmptyInput() {
        // Arrange
        String option = "1";
        String input = "   ";

        // Act
        String actual = Main.getOption(option, input);
        String expected ="The input must not be empty.";

        // Assert
        assertEquals(expected, actual);
    }
}

