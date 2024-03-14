package ru.astieriait.bot.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astieriait.bot.model.id.TimetableId;

import java.sql.Time;

@Entity
@Table(name = "timetable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Timetable {
    @EmbeddedId
    private TimetableId id;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;
}
