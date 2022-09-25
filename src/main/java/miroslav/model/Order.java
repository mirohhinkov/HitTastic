/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private long orderId;
    private long userId;
    private Date orderDate;
}
