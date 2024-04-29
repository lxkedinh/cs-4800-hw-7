package proxy;

import java.util.HashMap;
import java.util.List;

public class ProxySongServer implements SongService {
    private static ProxySongServer instance;
    private final SongServer realSongServer = SongServer.getInstance();
    private final HashMap<Integer, Song> songsByIdCache = new HashMap<>();
    private final HashMap<String, List<Song>> songsByTitleCache = new HashMap<>();
    private final HashMap<String, List<Song>> songsByAlbumCache = new HashMap<>();

    private ProxySongServer() {}

    public static ProxySongServer getInstance() {
        if (instance == null) {
            instance = new ProxySongServer();
        }

        return instance;
    }

    @Override
    public Song searchById(Integer songID) {
        if (songsByIdCache.containsKey(songID)) {
            return songsByIdCache.get(songID);
        }

        Song fetchedSong = realSongServer.searchById(songID);
        songsByIdCache.put(songID, fetchedSong);

        return fetchedSong;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        title = title.toLowerCase();
        if (songsByTitleCache.containsKey(title)) {
            return songsByTitleCache.get(title);
        }

        List<Song> fetchedSongs = realSongServer.searchByTitle(title);
        songsByTitleCache.put(title, fetchedSongs);

        return fetchedSongs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        album = album.toLowerCase();
        if (songsByAlbumCache.containsKey(album)) {
            return songsByAlbumCache.get(album);
        }

        List<Song> fetchedSongs = realSongServer.searchByAlbum(album);
        songsByAlbumCache.put(album, fetchedSongs);

        return fetchedSongs;
    }
}
