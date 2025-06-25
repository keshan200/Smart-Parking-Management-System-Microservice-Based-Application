package lk.ijse.payment_service.service;

import lk.ijse.payment_service.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO processPayment(PaymentDTO dto);
    List<PaymentDTO> getPaymentsByUser(Long userId);
}
