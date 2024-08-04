package com.example.demo.user;

import com.example.demo.security.JwtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.signup(userRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody UserRequestDTO userRequestDTO){
        JwtDTO jwtDTO = userService.login(userRequestDTO);
        return ResponseEntity.ok(jwtDTO);
    }
}
