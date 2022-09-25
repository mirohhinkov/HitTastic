/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetails {
    private long orderId;
    private Date orderDate;
    private long songId;
    private String title;
}
