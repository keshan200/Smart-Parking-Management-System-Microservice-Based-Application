package lk.ijse.payment_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long vehicleId;
    private Long spaceId;

    private BigDecimal amount;

    private LocalDateTime timestamp;

    private String paymentMethod; // Card, cash, etc.
}
