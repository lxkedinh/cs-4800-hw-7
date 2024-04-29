package test.flyweight;

import flyweight.CharacterProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterPropertiesTest {
    private CharacterProperties properties;

    @BeforeEach
    void setUp() {
        properties = new CharacterProperties("arial", "blue", 16);
    }

    @AfterEach
    void tearDown() {
        properties = null;
    }

    @Test
    void getFont() {
        assertEquals("arial", properties.getFont());
    }

    @Test
    void getColor() {
        assertEquals("blue", properties.getColor());
    }

    @Test
    void getSize() {
        assertEquals(16, properties.getSize());
    }

    @Test
    void serialize() {
        assertEquals("arial-blue-16", properties.serialize());
    }
}