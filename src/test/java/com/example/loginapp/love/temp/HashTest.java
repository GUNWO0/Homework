package com.example.loginapp.love.temp;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class HashTest {
    @Test
    public void encode_test() {
        // $2a$10$i1bXiG7ILY47VVrXQwy0h.ckyNN7/GS9r3AgKJFwTKOd3xxGxD0Wu
        String password = "1234";

        String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(encodedPassword);
    }
}
