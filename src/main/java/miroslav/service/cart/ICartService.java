/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.service.cart;

import miroslav.model.Song;

public interface ICartService {
    public void addSong(Song song, int quantity);
    public boolean changeQuantity(Song song, int newQuantity);
    public boolean increase(Song song);
    public boolean decrease(Song song);
    public boolean removeSong(Song song);
    public double cartPrice();
    public boolean createOrder();
    public void clearCart();
}


