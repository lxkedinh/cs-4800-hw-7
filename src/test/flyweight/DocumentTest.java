package test.flyweight;

import flyweight.Character;
import flyweight.CharacterProperties;
import flyweight.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {
    private Document doc;

    @BeforeEach
    void setUp() {
        doc = new Document();
    }

    @AfterEach
    void tearDown() {
        doc = null;
    }

    @Test
    void shouldReadFromFile() {
        // write characters to temporary file to then be read by document for testing, will be deleted after this test
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("readfiletest.txt"));
            writer.write("a arial-blue-16");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Writing temporary file for reading from file unit test went wrong.");
        }

        doc = new Document("readfiletest.txt");
        Character c = doc.undo();
        CharacterProperties p = c.getProperties();

        assertEquals('a', c.getCharacterValue());
        assertEquals("arial", p.getFont());
        assertEquals("blue", p.getColor());
        assertEquals(16, p.getSize());

        new File("readfiletest.txt").delete();
    }

    @Test
    void shouldWriteToDocument() {
        doc.write('b', "calibri-red-12");
        assertNotNull(doc.undo());
    }

    @Test
    void shouldUndoLastCharacter() {
        doc.write('b', "calibri-red-12");
        assertNotNull(doc.undo());
    }

    @Test
    void shouldSaveToFile() {
        doc.write('a', "arial-black-12");

        try {
            doc.saveToFile("writefiletest.txt");
        } catch (Exception e) {
           e.printStackTrace();
           fail("Something went wrong with saving to file unit test.");
        }

        File f = new File("writefiletest.txt");
        assertTrue(f.exists());
        f.delete();
    }
}