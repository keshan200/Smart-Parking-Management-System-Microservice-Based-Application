package lk.ijse.parking_service.service;


import lk.ijse.parking_service.dto.ParkingSpaceDTO;

import java.util.List;

public interface ParkingSpaceService {
    ParkingSpaceDTO create(ParkingSpaceDTO dto);
    ParkingSpaceDTO update(Long id, ParkingSpaceDTO dto);
    ParkingSpaceDTO getById(Long id);
    List<ParkingSpaceDTO> getAll();
    List<ParkingSpaceDTO> getByOwner(Long ownerId);
    void delete(Long id);
}
