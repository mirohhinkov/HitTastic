package miroslav.controller;

import miroslav.service.cart.CartService;
import miroslav.utils.State;

public class CartController {
    private static CartService cartService = new CartService();

    public static double cartPrice() {
        return cartService.cartPrice();
    }

    public static void actionsHandler(Long id, String action) {
        switch (action) {
            case "inc":
                cartService.increase(State.getInstance().getCart().getSongOrders().get(id).getSong());
                break;
            case "dec":
                cartService.decrease(State.getInstance().getCart().getSongOrders().get(id).getSong());
                break;
            case "del":
                cartService.removeSong(State.getInstance().getCart().getSongOrders().get(id).getSong());
                break;
        }
    }
}
