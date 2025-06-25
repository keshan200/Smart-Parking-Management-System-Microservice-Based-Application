package lk.ijse.parking_service.api;

import lk.ijse.parking_service.dto.ParkingSpaceDTO;
import lk.ijse.parking_service.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ParkingSpaceDTO dto) {
        String error = validate(dto);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpaceDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<ParkingSpaceDTO>> getByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(service.getByOwner(ownerId));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpaceDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ParkingSpaceDTO dto) {
        String error = validate(dto);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 🔒 Private validation helper
    private String validate(ParkingSpaceDTO dto) {
        if (dto == null) return "Parking space data is required.";
        if (dto.getSpaceIdentifier() == null || dto.getSpaceIdentifier().trim().isEmpty()) {
            return "Space identifier is required.";
        }
        if (dto.getLocation() == null || dto.getLocation().trim().isEmpty()) {
            return "Location is required.";
        }
        if (dto.getPricePerHour() == null || dto.getPricePerHour().compareTo(BigDecimal.ZERO) <= 0) {
            return "Price per hour must be greater than 0.";
        }
        if (dto.getOwnerId() == null) {
            return "Owner ID is required.";
        }
        if (dto.getStatus() == null) {
            return "Space status is required.";
        }
        return null;
    }
}
