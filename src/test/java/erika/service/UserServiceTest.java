package erika.service;

import erika.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void getAllUsers() {
        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();
        assertTrue(users.size() > 0);
    }
}