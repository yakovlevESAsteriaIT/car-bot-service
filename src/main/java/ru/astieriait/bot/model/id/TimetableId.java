package ru.astieriait.bot.model.id;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astieriait.bot.model.Manager;

import java.sql.Time;
import java.time.DayOfWeek;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TimetableId {
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "telegram_nickname")
    private Manager manager;
    @Enumerated(EnumType.STRING)
    private DayOfWeek day;
}
