package miroslav.dao.song;

import miroslav.model.Song;

import java.util.List;

/**
 *
 * @author Miroslav Hinkov
 */

public interface ISongDao {

    List<Song> getAllSongs();
    List<Song> getSongsByTitle(String title);
    List<Song> getSongsByArtist(String artistName);
    void addSong(Song song);
    void modifySong(Song song);
    void deleteSong(Song song);
}
