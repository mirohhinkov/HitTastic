/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.service.cart;


import erika.service.UserService;
import miroslav.dao.order.OrderDao;
import miroslav.model.Cart;
import miroslav.utils.State;
import miroslav.model.Song;
import miroslav.model.SongOrder;

/**
 *
 * @author M1R
 */
public class CartService implements ICartService {

    private final State state = State.getInstance();
    private final Cart cart = state.getCart();
    private OrderDao orderDao = new OrderDao();
    private UserService userService = new UserService();


    @Override
    public void addSong(Song song, int quantity) {
        if (quantity <= song.getQuantity())
            cart.getSongOrders().put(song.getId(), new SongOrder(song, quantity));
    }

    @Override
    public boolean changeQuantity(Song song, int newQuantity) {
        if (newQuantity < 1) return removeSong(song);
        if (newQuantity > song.getQuantity())
            return false;
        cart.getSongOrders().get(song.getId()).setQuantity(newQuantity);
        return true;
    }

    @Override
    public boolean increase(Song song) {
        if (cart.getSongOrders().containsKey(song.getId())) {
            int newQuantity = cart.getSongOrders().get(song.getId()).getQuantity() + 1;
            return changeQuantity(song, newQuantity);
        }
        return false;
    }

    @Override
    public boolean decrease(Song song) {
        if (cart.getSongOrders().containsKey(song.getId())) {
            int newQuantity = cart.getSongOrders().get(song.getId()).getQuantity() - 1;
            return changeQuantity(song, newQuantity);
        }
        return false;
    }

    @Override
    public boolean removeSong(Song song) {
        if (cart.getSongOrders().containsKey(song.getId())) {
            cart.getSongOrders().remove(song.getId());
            return true;
        }
        return false;
    }

    @Override
    public double cartPrice() {
        double cartP = 0;
        for (SongOrder order : state.getCart().getSongOrders().values())
            cartP += order.getQuantity() * order.getSong().getPrice();
        return cartP;
    }
    public void clearCart() {
        state.getCart().getSongOrders().clear();
    };
    @Override
    public boolean createOrder() {
        boolean orderMade = orderDao.makeOrder();
        double newBalance = State.getInstance().getUser().getBalance() - cartPrice();
        if (orderMade) userService.updateBalance(newBalance);
        return orderMade;
    }
}
