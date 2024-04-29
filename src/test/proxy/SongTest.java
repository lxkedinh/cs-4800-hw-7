package test.proxy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proxy.Song;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private Song s;

    @BeforeEach
    void setUp() {
        s = new Song("Vintage", "NIKI", "Zephyr", 3);
    }

    @AfterEach
    void tearDown() {
        s = null;
    }

    @Test
    void getTitle() {
        assertEquals("Vintage", s.getTitle());
    }

    @Test
    void getArtist() {
        assertEquals("NIKI", s.getArtist());
    }

    @Test
    void getAlbum() {
        assertEquals("Zephyr", s.getAlbum());
    }

    @Test
    void getDuration() {
        assertEquals(3, s.getDuration());
    }
}