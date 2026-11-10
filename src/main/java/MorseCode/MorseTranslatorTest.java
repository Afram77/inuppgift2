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
        String text ="HEJ";

        // Act
        String actual = translator.textToMorse(text);
        String expected =".... . .---";

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
        String expected = "Fel: tecknet 1 kan inte översättas.";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testMorseToWord() {
        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String morse =".... . .---";

        // Act
        String actual = translator.morseToText(morse);
        String expected ="HEJ";

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
        String expected ="Fel: morsekoden ...... finns inte.";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testInvalidCharacter() {
        // Arrange
        MorseTranslator translator = new MorseTranslator();
        String text ="HEJ!";

        // Act
        String actual = translator.textToMorse(text);
        String expected ="Fel: tecknet ! kan inte översättas.";

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    public void testMenuVal1() {
        // Arrange
        String val ="1";
        String inmatning ="HEJ";

        // Act
        String actual = Main.hanteraVal(val, inmatning);

        // Assert
        assertEquals(".... . .---", actual);
    }
    @Test
    public void testInvalidMenuVal() {
        // Arrange
        String val ="5";
        String inmatning ="HEJ";

        // Act
        String actual = Main.hanteraVal(val, inmatning);

        // Assert
        assertEquals("Ogiltigt val. Välj 1 eller 2.", actual);
    }
    @Test
    public void testEmptyInput() {
        // Arrange
        String val = "1";
        String inmatning = "   ";

        // Act
        String actual = Main.hanteraVal(val, inmatning);

        // Assert
        assertEquals("Inmatningen får inte vara tom.", actual);
    }
}

