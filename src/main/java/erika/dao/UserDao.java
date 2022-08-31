package erika.dao;

import erika.model.User;
import miroslav.utils.State;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    private final JdbcTemplate jdbcTemplate = State.getInstance().getJdbcTemplate();

    public List<User> getAllUsers() {
        String sqlQuery ="SELECT * FROM users";
        List<User> userList = jdbcTemplate.query(sqlQuery, new UserRowMapper());
        return userList;
    }
}
