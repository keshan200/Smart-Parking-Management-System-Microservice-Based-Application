package lk.ijse.parking_service.repository;


import lk.ijse.parking_service.entity.ParkingSpace;
import lk.ijse.parking_service.enums.SpaceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {
    List<ParkingSpace> findByOwnerId(Long ownerId);
    List<ParkingSpace> findByStatus(SpaceStatus status);
}
