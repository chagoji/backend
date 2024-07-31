package com.example.demo.user;

import com.example.demo.favorite.Favorite;
import com.example.demo.recommendation.Recommendation;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 50)
    private String status;

    @OneToMany(mappedBy = "user")
    private List<Recommendation> recommendations;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

}
