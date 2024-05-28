import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("", suggestions);
    }

    @Test
    public void testSingleEditDistance() {
        // Misspelled word "examlpe" should suggest "example"
        String word = "examlpe";
        String suggestions = suggestionEngine.generateSuggestions(word);
        assertEquals("example", suggestions);
    }

    @Test
    public void testDoubleEditDistance() {
        // Misspelled word "exmapl" should suggest "example"
        String word = "exmapl";
        String suggestions = suggestionEngine.generateSuggestions(word);
        assertEquals("example", suggestions);
    }
}

