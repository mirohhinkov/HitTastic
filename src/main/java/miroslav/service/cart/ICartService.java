/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miroslav.service.cart;

import miroslav.model.Song;

/**
 *
 * @author M1R
 */
public interface ICartService {
    public void addSong(Song song, int quantity);
    public boolean changeQuantity(Song song, int newQuantity);
    public boolean increase(Song song);
    public boolean decrease(Song song);
    public boolean removeSong(Song song);
    public double cartPrice();
    public boolean makeOrder();
}


