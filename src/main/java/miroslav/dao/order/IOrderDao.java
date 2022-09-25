/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.dao.order;

import miroslav.model.OrderDetails;

import java.util.List;

public interface IOrderDao {
    List<OrderDetails> findCurrentUserOrders();
    boolean makeOrder();

}
