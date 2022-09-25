package miroslav.controller;

import miroslav.model.Song;
import miroslav.service.cart.CartService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartControllerTest {
    CartService cartService = new CartService();
    @Test
    void cartPriceTest() {

        double oldCartPrice = CartController.cartPrice();

        // Test adding songs
        Song song = new Song();
        song.setPrice(2.5);
        song.setId(1);
        song.setQuantity(5);
        cartService.addSong(song, 2);
        Song song1 = new Song();
        song1.setPrice(1.35);
        song1.setId(2);
        song1.setQuantity(5);
        cartService.addSong(song1, 1);
        assertEquals(2 * 2.5 + 1 * 1.35, CartController.cartPrice() - oldCartPrice, 0.000000000000001);

        // Test increase quantity
        //the difference between tha end and start price of cart should be the price of the song
        oldCartPrice = CartController.cartPrice();
        cartService.increase(song1);
        assertEquals(song1.getPrice(), CartController.cartPrice() - oldCartPrice, 0.000000000000001);

        //Test decrease quantity
        //the difference between tha start and end price of cart should be the price of the song
        oldCartPrice = CartController.cartPrice();
        cartService.decrease(song);
        assertEquals(song.getPrice(), oldCartPrice - CartController.cartPrice(), 0.000000000000001);

        // Test remove song
        // Adding a song and remove it - the start and end prices should be equal
        // middle test that the song is added, before removing
        oldCartPrice = CartController.cartPrice();

        Song song2 = new Song();
        song2.setPrice(2.22);
        song2.setId(3);
        song2.setQuantity(5);
        cartService.addSong(song2, 3);

        // test the new cart price
        assertEquals(song2.getPrice() * 3, CartController.cartPrice() - oldCartPrice, 0.000000000000001);

        cartService.removeSong(song2);

        assertEquals(oldCartPrice, CartController.cartPrice(), 0.000000000000001);

    }

    @Test
    void actionsHandlerTest() {
        Song song = new Song();
        song.setPrice(2.5);
        song.setId(1);
        song.setQuantity(5);
        cartService.addSong(song, 2);
        Song song1 = new Song();
        song1.setPrice(1.35);
        song1.setId(2);
        song1.setQuantity(2);
        cartService.addSong(song1, 2);
        Song song2 = new Song();
        song2.setPrice(2.22);
        song2.setId(3);
        song2.setQuantity(5);
        cartService.addSong(song2, 3);

        // Test increase

        // song has an available quantity - expect true
        assertTrue(CartController.actionsHandler(1l, "inc"));
        // song1 has reached the stock quantity and has no available - expect false
        assertFalse(CartController.actionsHandler(2l, "inc"));
        // song with id = 5 in not in the cart - expect false
        assertFalse(CartController.actionsHandler(5l, "inc"));

        // Test decrease
        //songOrder quantity 2, decrease 1, new quantity 1, expected true
        assertTrue(CartController.actionsHandler(2l, "dec"));
        //decrease 1, new quantity 0, expected true and delete from cart
        assertTrue(CartController.actionsHandler(2l, "dec"));
        //Test if it is the cart - an increase should return false
        assertFalse(CartController.actionsHandler(2l, "inc"));
        // song with id = 5 in not in the cart - expect false
        assertFalse(CartController.actionsHandler(5l, "dec"));

        //Test delete

        // song id = 1, in cart - expect true
        assertTrue(CartController.actionsHandler(1l, "del"));
        // song not in the cart - expect false
        assertFalse(CartController.actionsHandler(5l, "del"));



    }
}