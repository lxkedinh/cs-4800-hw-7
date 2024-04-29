package test.proxy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proxy.ProxySongServer;
import proxy.Song;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ProxySongServerTest {
    private ProxySongServer proxy;

    @BeforeEach
    void setUp() {
        proxy = ProxySongServer.getInstance();

        // attempt to cache songs to test caching
        proxy.searchByAlbum("Gabriel");
        proxy.searchById(0);
        proxy.searchByTitle("Vintage");
    }

    @AfterEach
    void tearDown() {
        proxy = null;
    }

    @Test
    void getInstance() {
        assertNotNull(ProxySongServer.getInstance());
    }

    @Test
    void sHouldCachedSearchById() {
        long start = System.nanoTime();
        Song s = proxy.searchById(0);
        long end = System.nanoTime();
        assertNotNull(s);
        assertTrue(end - start < TimeUnit.SECONDS.toNanos(1));
    }

    @Test
    void shouldCachedSearchByTitle() {
        long start = System.nanoTime();
        List<Song> s = proxy.searchByTitle("Vintage");
        long end = System.nanoTime();
        assertFalse(s.isEmpty());
        assertTrue(end - start < TimeUnit.SECONDS.toNanos(1));
    }

    @Test
    void shouldCachedSearchByAlbum() {
        long start = System.nanoTime();
        List<Song> s = proxy.searchByAlbum("Gabriel");
        long end = System.nanoTime();
        assertFalse(s.isEmpty());
        assertTrue(end - start < TimeUnit.SECONDS.toNanos(1));
    }
}