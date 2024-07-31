package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long userId;
    private String username;
    private String email;
    private String status;
}
