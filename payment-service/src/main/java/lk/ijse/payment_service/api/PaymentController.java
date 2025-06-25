package lk.ijse.payment_service.api;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<?> pay(@RequestBody PaymentDTO dto) {
        // Basic validation
        String error = validatePaymentDTO(dto);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }

        PaymentDTO result = service.processPayment(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}")
    public List<PaymentDTO> getUserPayments(@PathVariable Long userId) {
        return service.getPaymentsByUser(userId);
    }

    // 🔒 Private helper for simple validation
    private String validatePaymentDTO(PaymentDTO dto) {
        if (dto == null) {
            return "Payment data must not be null.";
        }
        if (dto.getUserId() == null) {
            return "User ID is required.";
        }
        if (dto.getAmount() == null || dto.getAmount().doubleValue() <= 0) {
            return "Payment amount must be greater than 0.";
        }
        if (dto.getPaymentMethod() == null || dto.getPaymentMethod().trim().isEmpty()) {
            return "Payment method is required.";
        }
        return null;
    }
}
