package ru.astieriait.bot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "car_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "telegram_nickname")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "telegram_nickname")
    private Manager manager;
    private Boolean handled;
    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @UpdateTimestamp
    @Column(name = "last_update_at")
    private LocalDateTime lastUpdateAt;
}
