package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long propertyId;

    @Column(nullable = false)
    private int buildYear;

    @Column(nullable = false)
    private int sigunguCode;

    @Column(nullable = false)
    private int eupmyundongCode;

    @Column(nullable = false, length = 50)
    private String sigungu;

    @Column(nullable = false, length = 50)
    private String dong;

    @Column(nullable = false, length = 50)
    private String aptName;

    @Column(nullable = false)
    private double dedicatedArea;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private int dealYear;

    @Column(nullable = false)
    private int dealMonth;

    @Column(nullable = false)
    private int dealDay;

    @OneToMany(mappedBy = "property")
    private List<Recommendation> recommendations;

    @OneToMany(mappedBy = "property")
    private List<PricePrediction> pricePredictions;

    @OneToMany(mappedBy = "property")
    private List<Favorite> favorites;

}
