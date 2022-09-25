/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.service.song;

import java.util.List;
import miroslav.dao.song.SongDao;
import miroslav.model.Song;

public class SongService implements ISongService {
    
    private final SongDao songDao = new SongDao();


    @Override
    public List<Song> getAllSongs() {
        return songDao.getAllSongs();
    }

    @Override
    public List<Song> getSongsByTitle(String title) {
        return songDao.getSongsByTitle(title);
    }

    @Override
    public List<Song> getSongsByArtist(String artistName) {
        return songDao.getSongsByArtist(artistName);
    }
    
    
    
}
