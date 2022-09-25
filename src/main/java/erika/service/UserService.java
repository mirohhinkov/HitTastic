package erika.service;

import erika.dao.UserDao;
import erika.model.User;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService {
    
    private final UserDao userDao;
    
    public UserService() {
        userDao = new UserDao();
    }
    
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    public void updateBalance(double newBalance) {
        userDao.updateBalance(newBalance);
    }
    
}
