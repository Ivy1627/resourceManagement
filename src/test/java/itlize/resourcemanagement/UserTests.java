package itlize.resourcemanagement;

import itlize.resourcemanagement.entity.User;
import itlize.resourcemanagement.repository.UserRepo;
import itlize.resourcemanagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepo ur;
    @Autowired
    private UserService us;

    @Test
    void testCreateUser() {
        // Create a new user
        User newUser = new User();
        newUser.setUser("Joshua", "87600543");

        // Test case: Creating a new user
        boolean result = us.createUser(newUser);
        assertTrue(result);

        // Verify that the user was saved
        User savedUser = ur.findByUsername("Joshua");
        assertNotNull(savedUser);
        assertEquals("Joshua", savedUser.getUsername());

        // Test case: Trying to create the same user again
        result = us.createUser(newUser);
        assertFalse(result);
    }

    @Test
    void TestUpdatePassword(){
        boolean success = us.updatePassword("Ivy", "1091008");
        User updatedUser = ur.findByUsername("Ivy");
        assertTrue(success);
        assertEquals("1091008", updatedUser.getPassword());
    }

    @Test
    void TestDeleteUser(){
//        User user = us.updatePassword("Mark", "123456");
//        ur.save(user);
        us.deleteUser("John", "876543");
    }
}
