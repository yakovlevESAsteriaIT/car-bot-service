package ru.astieriait.bot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import ru.astieriait.bot.model.id.ContactDataId;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactData {
    @EmbeddedId
    private ContactDataId id;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "telegram_nickname")
    private Customer customer;
    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;
}
