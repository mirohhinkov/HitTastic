/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miroslav.service.song;

import java.util.List;
import miroslav.model.Song;

/**
 *
 * @author miro
 */
public interface ISongService {

    List<Song> getAllSongs();
    
    List<Song> getSongsByTitle(String title);
    
    List<Song> getSongsByArtist(String artistName);
}
