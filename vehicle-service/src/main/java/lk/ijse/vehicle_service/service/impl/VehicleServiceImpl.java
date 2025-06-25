package lk.ijse.vehicle_service.service.impl;

import lk.ijse.vehicle_service.dto.VehicleDTO;
import lk.ijse.vehicle_service.entity.Vehicle;
import lk.ijse.vehicle_service.mapper.VehicleMapper;
import lk.ijse.vehicle_service.repository.VehicleRepository;
import lk.ijse.vehicle_service.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDTO registerVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDTO);
        Vehicle saved = vehicleRepository.save(vehicle);
        return VehicleMapper.toDTO(saved);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDTO);
        Vehicle updated = vehicleRepository.save(vehicle);
        return VehicleMapper.toDTO(updated);
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .map(VehicleMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<VehicleDTO> getVehiclesByOwnerId(String ownerId) {
        return vehicleRepository.findByOwnerId(ownerId).stream()
                .map(VehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void simulateEntry(String licensePlate) {
        Vehicle vehicle = vehicleRepository.findByLicensePlate(licensePlate);
        if (vehicle != null) {
            vehicle.setParked(true);
            vehicleRepository.save(vehicle);
        }
    }

    @Override
    public void simulateExit(String licensePlate) {
        Vehicle vehicle = vehicleRepository.findByLicensePlate(licensePlate);
        if (vehicle != null) {
            vehicle.setParked(false);
            vehicleRepository.save(vehicle);
        }
    }
}
