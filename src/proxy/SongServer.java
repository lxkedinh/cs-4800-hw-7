package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SongServer implements SongService {
    private static SongServer server = null;
    private static int idCounter = 0;
    private final HashMap<Integer, Song> songsById = new HashMap<>();
    private final HashMap<String, List<Song>> songsByTitle = new HashMap<>();
    private final HashMap<String, List<Song>> songsByAlbum = new HashMap<>();

    private SongServer() {
        addSong(new Song("ANGOSTURA", "Keshi", "Gabriel", 4));
        addSong(new Song("SOMEBODY", "Keshi", "Gabriel", 4));
        addSong(new Song("TOUCH", "Keshi", "Gabriel", 4));
        addSong(new Song("Vintage", "NIKI", "Zephyr", 3));
        addSong(new Song("Winter (The Wind Can Be Still)", "ConcernedApe", "Stardew Valley (Original Game Soundtrack)", 3));
    }

    public static SongServer getInstance() {
        if (server == null) {
            server = new SongServer();
        }

        return server;
    }

    public void addSong(Song song) {
        String title = song.getTitle().toLowerCase();
        String album = song.getAlbum().toLowerCase();

        songsById.put(idCounter, song);
        idCounter++;

        if (!songsByTitle.containsKey(title)) {
            songsByTitle.put(title, new ArrayList<>());
        }
        songsByTitle.get(title).add(song);

        if (!songsByAlbum.containsKey(album)) {
            songsByAlbum.put(album, new ArrayList<>());
        }
        songsByAlbum.get(album).add(song);
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            System.out.println("Fetching song by ID from server...");
           Thread.sleep(1000);
        } catch (Exception e) {}

        return songsById.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            System.out.println("Fetching songs by title from server...");
            Thread.sleep(1000);
        } catch (Exception e) {}

        return songsByTitle.get(title.toLowerCase());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            System.out.println("Fetching songs by album from server...");
            Thread.sleep(1000);
        } catch (Exception e) {}

        return songsByAlbum.get(album.toLowerCase());
    }
}
