package lk.ijse.payment_service.service.impl;

import lk.ijse.payment_service.dto.PaymentDTO;
import lk.ijse.payment_service.entity.Payment;
import lk.ijse.payment_service.repository.PaymentRepository;
import lk.ijse.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    private PaymentDTO toDTO(Payment entity) {
        return new PaymentDTO(
                entity.getId(),
                entity.getUserId(),
                entity.getVehicleId(),
                entity.getSpaceId(),
                entity.getAmount(),
                entity.getTimestamp(),
                entity.getPaymentMethod()
        );
    }

    private Payment toEntity(PaymentDTO dto) {
        return new Payment(
                dto.getId(),
                dto.getUserId(),
                dto.getVehicleId(),
                dto.getSpaceId(),
                dto.getAmount(),
                dto.getTimestamp(),
                dto.getPaymentMethod()
        );
    }

    @Override
    public PaymentDTO processPayment(PaymentDTO dto) {
        dto.setTimestamp(LocalDateTime.now());
        Payment saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public List<PaymentDTO> getPaymentsByUser(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
