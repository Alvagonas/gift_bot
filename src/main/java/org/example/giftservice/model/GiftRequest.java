package org.example.giftservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gift_requests")
public class GiftRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String recipientName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String hobbies;

    @Column(nullable = false, length = 50)
    private String budget;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String fullRequestText;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}