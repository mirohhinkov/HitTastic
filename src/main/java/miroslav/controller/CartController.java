/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.controller;

import miroslav.dao.order.OrderDao;
import miroslav.model.OrderDetails;
import miroslav.service.cart.CartService;
import miroslav.utils.State;


import java.util.List;

public class CartController {
    private static CartService cartService = new CartService();
    private static OrderDao orderDao = new OrderDao();

    public static double cartPrice() {
        return cartService.cartPrice();
    }

    public static boolean actionsHandler(Long id, String action) {
        if (!State.getInstance().getCart().getSongOrders().containsKey(id)) return false;
        switch (action) {
            case "inc":
                return cartService.increase(State.getInstance().getCart().getSongOrders().get(id).getSong());
//                break;
            case "dec":
                return cartService.decrease(State.getInstance().getCart().getSongOrders().get(id).getSong());
//                break;
            case "del":
                return cartService.removeSong(State.getInstance().getCart().getSongOrders().get(id).getSong());
//                break;
            default:
                return false;
        }

    }

    public static boolean buyCart() {
        return cartService.createOrder();
    }

    public static void clearCart() {
        cartService.clearCart();
    }

    public static List<OrderDetails> findCurrentUserOrders() {

        return orderDao.findCurrentUserOrders();
    }
}
