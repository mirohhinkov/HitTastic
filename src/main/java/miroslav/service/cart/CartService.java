/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miroslav.service.cart;

import java.util.ArrayList;
import java.util.HashMap;

import miroslav.model.Cart;
import miroslav.utils.State;
import miroslav.model.Song;
import miroslav.model.SongOrder;

/**
 *
 * @author M1R
 */
public class CartService implements ICartService {
    
    private final Cart cart = State.getInstance().getCart();

    @Override
    public void addSong(Song song, int quantity) {
        cart.getSongOrders().put(Long.valueOf(song.getId()), new SongOrder(song, quantity));
    }

    @Override
    public boolean changeQuantity(Song song, int newQuantity) {
//        if (newQuantity < 1) return false;
//        if (newQuantity == 0) return this.removeSong(song);
//        for (SongOrder s : songs) {
//            if (s.getSong().getId() == song.getId()) {
//                s.setQuantity(newQuantity);
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public boolean removeSong(Song song) {
//        for (SongOrder s : songs) {
//            if (s.getSong().getId() == song.getId()) {
//                songs.remove(s);
//                return true;
//            }
//        }
        return false;    
    }    

    @Override
    public boolean makeOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
