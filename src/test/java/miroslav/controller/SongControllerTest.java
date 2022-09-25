package miroslav.controller;

import miroslav.model.Song;
import miroslav.service.cart.CartService;
import miroslav.service.song.SongService;
import miroslav.utils.State;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongControllerTest {
    private static CartService cartService = new CartService();
    @Test
    void searchTest() {
        State state = State.getInstance();
        state.setFilter("Metallica");
        SongService songService= new SongService();
        List<Song> songs = songService.getAllSongs(); // retrieve songs from DB

        int count = 0; // counter for number of songs
        // Counts how many songs of Metalicca in all songs
        for (Song song : songs) {
            count += (song.getArtist().getName().equals(state.getFilter())) ? 1 : 0;
        }

        SongController.search();
        // Checks the result of search() with the calculated one
        assertEquals(count, state.getSongs().size());
    }

    @Test
    void availableQuantityTest() {
        Song song = new Song();
        song.setPrice(2.5);
        song.setId(1);
        song.setQuantity(5);
        cartService.addSong(song, 2);

        // stock quantity 5, added to cart 2, available expected - 3
        assertEquals(3, SongController.availableQuantity(song));
    }
}