package com.hau.login_identity.Repository;

import com.hau.login_identity.Model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    public Optional<User> findByUsername(String username) {
        // Giả lập dữ liệu trả về
        if (username.equals("admin")) {
            User user = new User();
            user.setId(1L);
            user.setUsername("admin");
            user.setPassword("12345678");
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
