package lk.ijse.vehicle_service.repository;

import lk.ijse.vehicle_service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByOwnerId(String ownerId);
    Vehicle findByLicensePlate(String licensePlate);
}
