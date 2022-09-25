/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsRowMapper implements RowMapper<OrderDetails>{
    @Override
    public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(rs.getLong("order_id"));
        orderDetails.setSongId(rs.getLong("song_id"));
        orderDetails.setOrderDate(rs.getDate("order_date"));
        orderDetails.setTitle(rs.getString("title"));
        return orderDetails;
    }
}