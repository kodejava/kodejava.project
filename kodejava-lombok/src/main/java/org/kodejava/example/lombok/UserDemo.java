package org.kodejava.example.lombok;

import org.kodejava.example.lombok.domain.User;

import java.time.LocalDate;

public class UserDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("foo");
        user.setPassword("secret");
        user.setLastLogin(LocalDate.now());
        user.setActive(true);

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getLastLogin());
        System.out.println(user.isActive());
    }
}
