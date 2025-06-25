package lk.ijse.vehicle_service.api;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<?> registerVehicle(@RequestBody VehicleDTO vehicleDTO) {
        // Manual field validation
        String error = validateVehicleDTO(vehicleDTO);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }

        VehicleDTO savedVehicle = vehicleService.registerVehicle(vehicleDTO);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody VehicleDTO vehicleDTO) {
        // Manual field validation
        String error = validateVehicleDTO(vehicleDTO);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }

        vehicleDTO.setId(id);
        VehicleDTO updatedVehicle = vehicleService.updateVehicle(vehicleDTO);
        return ResponseEntity.ok(updatedVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
        VehicleDTO vehicleDTO = vehicleService.getVehicleById(id);
        if (vehicleDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicleDTO);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByOwner(@PathVariable String ownerId) {
        List<VehicleDTO> vehicles = vehicleService.getVehiclesByOwnerId(ownerId);
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/entry/{licensePlate}")
    public ResponseEntity<Void> simulateEntry(@PathVariable String licensePlate) {
        vehicleService.simulateEntry(licensePlate);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/exit/{licensePlate}")
    public ResponseEntity<Void> simulateExit(@PathVariable String licensePlate) {
        vehicleService.simulateExit(licensePlate);
        return ResponseEntity.ok().build();
    }

    // 🔒 Private helper method for simple validation
    private String validateVehicleDTO(VehicleDTO dto) {
        if (dto.getLicensePlate() == null || dto.getLicensePlate().trim().isEmpty()) {
            return "License plate is required.";
        }
        if (dto.getModel() == null || dto.getModel().trim().isEmpty()) {
            return "Model is required.";
        }
        if (dto.getOwnerId() == null || dto.getOwnerId().trim().isEmpty()) {
            return "Owner ID is required.";
        }
        return null;
    }
}
