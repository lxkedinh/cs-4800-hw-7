package test.proxy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proxy.Song;
import proxy.SongServer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongServerTest {
    private SongServer server;

    @BeforeEach
    void setUp() {
        server = SongServer.getInstance();
    }

    @AfterEach
    void tearDown() {
        server = null;
    }

    @Test
    void shouldGetInstance() {
        assertNotNull(SongServer.getInstance());
    }

    @Test
    void addSong() {
        Song s = new Song("test", "test", "test", 4);
        server.addSong(s);
        assertEquals(s, server.searchByTitle("test").get(0));
    }

    @Test
    void searchById() {
        assertNotNull(server.searchById(0));
    }

    @Test
    void searchByTitle() {
        assertFalse(server.searchByTitle("ANGOSTURA").isEmpty());
    }

    @Test
    void searchByAlbum() {
        assertFalse(server.searchByAlbum("Gabriel").isEmpty());
    }
}