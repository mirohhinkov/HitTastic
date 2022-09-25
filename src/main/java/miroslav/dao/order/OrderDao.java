/**
 *
 * @author Miroslav Hinkov
 */
package miroslav.dao.order;

import miroslav.model.OrderDetails;
import miroslav.model.OrderDetailsRowMapper;
import miroslav.model.SongOrder;
import miroslav.utils.State;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDao implements IOrderDao {
    private JdbcTemplate jdbcTemplate = State.getInstance().getJdbcTemplate();

    @Override
    public List<OrderDetails> findCurrentUserOrders() {
        String sqlQuery = "SELECT o.order_id, o.order_date, os.song_id, s.title FROM user_orders o join ordered_songs os Using (order_id) join songs s ON s.songs_id = os.song_id WHERE o.user_id=? ORDER BY o.order_id";
        List<OrderDetails> orders = jdbcTemplate.query(sqlQuery, new OrderDetailsRowMapper(), new Object[] {State.getInstance().getUser().getId()});
        return orders;
    }

    @Override
    public boolean makeOrder() {
        // create new order
        try {
            String sqlQuery = "INSERT INTO user_orders(user_id) VALUES (?)".
                    replace("?", "" + State.getInstance().getUser().getId());
            jdbcTemplate.execute(sqlQuery);
            // get the order_id of the new order
            sqlQuery = "SELECT order_id FROM user_orders ORDER BY order_id DESC LIMIT 1";
            long orderId = jdbcTemplate.queryForObject(sqlQuery, new RowMapper<Long>() {
                @Override
                public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                    long id = rs.getLong("order_id");
                    return id;
                }
            });
            // place the ordered songs in ordered-songs and decrease the purchased quantity from the stock
            double balance = 0;
            for (SongOrder order : State.getInstance().getCart().getSongOrders().values()) {
                // place the ordered songs in ordered-songs
                int orderedQuantity = order.getQuantity();
                sqlQuery = "INSERT INTO ordered_songs(order_id, song_id, quantity) VALUES (?,!,#)"
                        .replace("?", "" + orderId)
                        .replace("!", "" + order.getSong().getId())
                        .replace("#", "" + orderedQuantity);
                balance += orderedQuantity *
                        order.getSong().getPrice();
                jdbcTemplate.execute(sqlQuery);
                int newStock = order.getSong().getQuantity() - orderedQuantity;
                // update the stock
                sqlQuery = "UPDATE songs SET quantity=? WHERE songs_id=#"
                        .replace("?", "" + newStock)
                        .replace("#", "" + order.getSong().getId());
                jdbcTemplate.execute(sqlQuery);
            }
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
