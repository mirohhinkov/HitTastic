package erika.dao;

import erika.model.User;
import miroslav.utils.State;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    private final JdbcTemplate jdbcTemplate = State.getInstance().getJdbcTemplate();

    public List<User> getAllUsers() {
        String sql ="SELECT * FROM users";
        List<User> userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList;
    }

    public User findUserByEmail(String email) {
        String sql ="SELECT * FROM users WHERE email = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    // @author Miroslav Hinkov
    public void updateBalance(double newBalance) {
        String sql = "UPDATE users SET balance=1 WHERE id=2"
                .replace("1", "" + newBalance)
                .replace("2", "" + State.getInstance().getUser().getId());
        System.out.println(sql);
        jdbcTemplate.execute(sql);
    }
}
