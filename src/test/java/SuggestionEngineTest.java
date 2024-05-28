import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class SuggestionEngineTest {

    private SuggestionEngine suggestionEngine;

    @BeforeEach
    public void setUp() throws Exception {
        suggestionEngine = new SuggestionEngine();
        Path dictionaryFile = Paths.get("src/test/resources/words.txt");
        suggestionEngine.loadDictionaryData(dictionaryFile);
    }

    @Test
    public void testCorrectWord() {
        // Word "example" exists in the dictionary
        String word = "example";
        String suggestions = suggestionEngine.generateSuggestions(word);
        Assertions.assertEquals("", suggestions);
    }

    @Test
    public void testEmptyInput() {
        String word = "";
        String suggestions = suggestionEngine.generateSuggestions(word);
        Assertions.assertEquals("", suggestions, "The input is empty, so there should be no suggestions.");
    }

    @Test
    public void testNonexistentWord() {
        String word = "nonexistent";
        String suggestions = suggestionEngine.generateSuggestions(word);
        Assertions.assertEquals("", suggestions, "The word is not in the dictionary, so there should be no suggestions.");
    }

    @Test
    public void testSpecialCharacters() {
        String word = "spec!@#$%^&*()_ial";
        String suggestions = suggestionEngine.generateSuggestions(word);
        Assertions.assertEquals("", suggestions, "The word contains special characters, so there should be no suggestions.");
    }

}

