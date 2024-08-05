package com.example.demo.user;

import com.example.demo.security.JwtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

    @GetMapping("/loginSuccess")
    public ResponseEntity<Object> loginSuccess(OAuth2AuthenticationToken authentication) {
        OAuth2User oAuth2User = authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        return ResponseEntity.ok().body("Login successful with email: " + email);
    }

    @GetMapping("/loginFailure")
    public ResponseEntity<Object> loginFailure() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
    }
}
