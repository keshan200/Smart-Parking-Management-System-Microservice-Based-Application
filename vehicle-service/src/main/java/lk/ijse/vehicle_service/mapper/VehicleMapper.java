package lk.ijse.vehicle_service.mapper;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.entity.Vehicle;

public class VehicleMapper {

    public static VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) return null;
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setLicensePlate(vehicle.getLicensePlate());
        dto.setModel(vehicle.getModel());
        dto.setOwnerId(vehicle.getOwnerId());
        dto.setParked(vehicle.isParked());
        return dto;
    }

    public static Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) return null;
        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getId());
        vehicle.setLicensePlate(dto.getLicensePlate());
        vehicle.setModel(dto.getModel());
        vehicle.setOwnerId(dto.getOwnerId());
        vehicle.setParked(dto.isParked());
        return vehicle;
    }
}
