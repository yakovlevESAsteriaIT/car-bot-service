package ru.astieriait.bot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "telegram_nickname")
    private String telegramNickname;
    @OneToMany(mappedBy = "customer")
    private List<CarOrder> carOrders;
    @OneToMany(mappedBy = "customer")
    private List<ContactData> contactDataList;
}
