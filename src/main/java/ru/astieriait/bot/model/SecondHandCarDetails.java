package ru.astieriait.bot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "second_hand_car_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecondHandCarDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "owners_amount")
    private Integer ownersAmount;
    private Integer mileage;
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
