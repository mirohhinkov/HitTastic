/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miroslav.controller;

import java.util.List;
import miroslav.model.Song;
import miroslav.service.song.SongService;
import miroslav.utils.State;

/**
 *
 * @author miro
 */
public class SongController {
    private static final State state = State.getInstance();
    private static SongService songService = new SongService();
    public static void search() {
        
        String filter = state.getFilter();
        List<Song> songs;
        if (filter == null || filter.isEmpty()) {
            songs = songService.getAllSongs();
        } else {
           songs = songService.getSongsByArtist(filter);
           if (songs.isEmpty()) {
               songs = songService.getSongsByTitle(filter);
           }
        }
        state.setSongs(songs);
    }

    public static int availableQuantity(Song song) {
        int qtyInCart = (state.getCart().getSongOrders().get(song.getId()) == null)
                ? 0 : state.getCart().getSongOrders().get(song.getId()).getQuantity();
        return song.getQuantity() - qtyInCart;
    }
    
}
