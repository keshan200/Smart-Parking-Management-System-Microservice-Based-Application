package lk.ijse.payment_service.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long id;
    private Long userId;
    private Long vehicleId;
    private Long spaceId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String paymentMethod;
}
