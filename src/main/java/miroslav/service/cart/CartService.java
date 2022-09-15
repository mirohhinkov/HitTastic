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
    private final State state = State.getInstance();

    @Override
    public void addSong(Song song, int quantity) {
        cart.getSongOrders().put(song.getId(), new SongOrder(song, quantity));
    }

    @Override
    public boolean changeQuantity(Song song, int newQuantity) {
        if (newQuantity < 1) return this.removeSong(song);
        if (newQuantity > song.getQuantity())
            return false;
        state.getCart().getSongOrders().get(song.getId()).setQuantity(newQuantity);
        return true;
    }

    @Override
    public boolean increase(Song song) {
        int newQuantity = state.getCart().getSongOrders().get(song.getId()).getQuantity() + 1;
        return changeQuantity(song, newQuantity);
    }

    @Override
    public boolean decrease(Song song) {
        int newQuantity = state.getCart().getSongOrders().get(song.getId()).getQuantity() - 1;
        return changeQuantity(song, newQuantity);
    }

    @Override
    public boolean removeSong(Song song) {
        state.getCart().getSongOrders().remove(song.getId());
        return true;
    }

    @Override
    public double cartPrice() {
        double cartP = 0;
        for (SongOrder order : state.getCart().getSongOrders().values())
            cartP += order.getQuantity() * order.getSong().getPrice();
        return cartP;
    }

    @Override
    public boolean makeOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
