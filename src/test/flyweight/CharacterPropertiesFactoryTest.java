package test.flyweight;

import flyweight.CharacterProperties;
import flyweight.CharacterPropertiesFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterPropertiesFactoryTest {
    private CharacterPropertiesFactory factory;

    @BeforeEach
    void setUp() {
        factory = CharacterPropertiesFactory.getInstance();
    }

    @AfterEach
    void tearDown() {
        factory = null;
    }

    @Test
    void shouldGetInstance() {
        assertNotNull(factory);
    }

    @Test
    void shouldGetNewCharacterProperties() {
        CharacterProperties c = factory.getCharacterProperties("arial-red-12");
        assertNotNull(c);
    }

    @Test
    void shouldGetSameCharacterPropertiesInstance() {
        CharacterProperties firstProperties = factory.getCharacterProperties("arial-red-12");
        CharacterProperties shouldBeSameProperties = factory.getCharacterProperties("arial-red-12");
        assertSame(firstProperties, shouldBeSameProperties);
    }
}