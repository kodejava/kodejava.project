package org.kodejava.example.lombok.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private LocalDate lastLogin;
    private boolean active;
}
