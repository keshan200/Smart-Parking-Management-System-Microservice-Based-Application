package lk.ijse.parking_service.service.impl;

import lk.ijse.parking_service.dto.ParkingSpaceDTO;
import lk.ijse.parking_service.entity.ParkingSpace;
import lk.ijse.parking_service.mapper.ParkingSpaceMapper;
import lk.ijse.parking_service.repository.ParkingSpaceRepository;
import lk.ijse.parking_service.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository repository;

    @Override
    public ParkingSpaceDTO create(ParkingSpaceDTO dto) {
        ParkingSpace saved = repository.save(ParkingSpaceMapper.toEntity(dto));
        return ParkingSpaceMapper.toDTO(saved);
    }

    @Override
    public ParkingSpaceDTO update(Long id, ParkingSpaceDTO dto) {
        ParkingSpace existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parking space not found with ID: " + id));

        existing.setLocation(dto.getLocation());
        existing.setSpaceIdentifier(dto.getSpaceIdentifier());
        existing.setPricePerHour(dto.getPricePerHour());
        existing.setStatus(dto.getStatus());
        existing.setOwnerId(dto.getOwnerId());

        ParkingSpace updated = repository.save(existing);
        return ParkingSpaceMapper.toDTO(updated);
    }

    @Override
    public ParkingSpaceDTO getById(Long id) {
        return repository.findById(id)
                .map(ParkingSpaceMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Parking space not found with ID: " + id));
    }

    @Override
    public List<ParkingSpaceDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(ParkingSpaceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkingSpaceDTO> getByOwner(Long ownerId) {
        return repository.findByOwnerId(ownerId)
                .stream()
                .map(ParkingSpaceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
