package ru.astieriait.bot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "manager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    @Column(name = "telegram_nickname")
    private String telegramNickname;
    @OneToMany(mappedBy = "manager")
    private List<CarOrder> carOrders;
    @OneToMany(mappedBy = "id.manager")
    private List<Timetable> timetables;
    private Boolean active;
}
