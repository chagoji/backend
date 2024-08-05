package com.example.demo.user;

import com.example.demo.security.JwtDTO;
import com.example.demo.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public UserResponseDTO signup(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setStatus("ACTIVE");

        User savedUser = userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(savedUser.getUserId());
        userResponseDTO.setUsername(savedUser.getUsername());
        userResponseDTO.setEmail(savedUser.getEmail());
        userResponseDTO.setStatus(savedUser.getStatus());

        return userResponseDTO;
    }

    public JwtDTO login(UserRequestDTO userRequestDTO) {
        User user = userRepository.findByEmail(userRequestDTO.getEmail());
        if (user == null || !passwordEncoder.matches(userRequestDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String accessToken = jwtProvider.createToken(user.getEmail());
        String refreshToken = jwtProvider.createRefreshToken(user.getEmail());
        return new JwtDTO(accessToken, refreshToken);
    }
}
