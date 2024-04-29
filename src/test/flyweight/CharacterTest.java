package test.flyweight;

import flyweight.Character;
import flyweight.CharacterProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character('a', "arial-red-12");
    }

    @AfterEach
    void tearDown() {
        character = null;
    }

    @Test
    void shouldGetCharacterValue() {
        assertEquals('a', character.getCharacterValue());
    }

    @Test
    void shouldSetCharacterValue() {
        character.setCharacterValue('b');
        assertEquals('b', character.getCharacterValue());
    }

    @Test
    void shouldGetProperties() {
        CharacterProperties properties = character.getProperties();
        assertNotNull(properties);
    }

    @Test
    void shouldSetProperties() {
        character.setProperties("calibri-blue-16");
        CharacterProperties properties = character.getProperties();

        assertEquals("calibri", properties.getFont());
        assertEquals("blue", properties.getColor());
        assertEquals(16, properties.getSize());
    }
}