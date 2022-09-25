/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.service.song;

import java.util.List;
import miroslav.model.Song;

public interface ISongService {

    List<Song> getAllSongs();
    
    List<Song> getSongsByTitle(String title);
    
    List<Song> getSongsByArtist(String artistName);
}
