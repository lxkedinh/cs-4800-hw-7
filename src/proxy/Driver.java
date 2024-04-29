package proxy;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        SongService server = ProxySongServer.getInstance();

        System.out.println("First search by song ID, not cached");
        Song firstSong = server.searchById(0);

        System.out.println(firstSong);
        System.out.println();

        System.out.println("Second search by song ID, cached");
        Song cachedFirstSong = server.searchById(0);

        System.out.println(cachedFirstSong);
        System.out.println();

        System.out.println("First search by title, not cached");
        List<Song> vintage = server.searchByTitle("Vintage");

        for (Song s: vintage) {
            System.out.println(s);
            System.out.println();
        }

        System.out.println("Second search by title, cached");
        List<Song> cachedVintage = server.searchByTitle("Vintage");

        for (Song s: cachedVintage) {
            System.out.println(s);
            System.out.println();
        }

        System.out.println("First search by album, not cached");
        List<Song> albumResults = server.searchByAlbum("Gabriel");

        for (Song s: albumResults) {
            System.out.println(s);
            System.out.println();
        }

        System.out.println("Second search for same album, cached by proxy server");
        List<Song> cachedAlbumResults = server.searchByAlbum("Gabriel");

        for (Song s: cachedAlbumResults) {
            System.out.println(s);
            System.out.println();
        }


    }
}
