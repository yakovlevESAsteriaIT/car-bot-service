package ru.astieriait.bot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Integer power;
    private String description;
    private BigDecimal price;
    private Boolean disable;
    @Column(name = "four_wheel_drive")
    private Boolean fourWheelDrive;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private SecondHandCarDetails secondHandCarDetails;
}
