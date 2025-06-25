package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO registerVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getVehicleById(Long id);
    List<VehicleDTO> getVehiclesByOwnerId(String ownerId);
    void simulateEntry(String licensePlate);
    void simulateExit(String licensePlate);
}
