package org.example.giftservice.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GiftResponse {
    private Long id;
    private String fullRequestText;
    private LocalDateTime createdAt;
    private String status = "SUCCESS";
}