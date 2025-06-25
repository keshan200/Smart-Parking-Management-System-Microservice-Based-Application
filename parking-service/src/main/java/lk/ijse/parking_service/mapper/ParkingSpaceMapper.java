package lk.ijse.parking_service.mapper;


import lk.ijse.parking_service.dto.ParkingSpaceDTO;
import lk.ijse.parking_service.entity.ParkingSpace;

public class ParkingSpaceMapper {

    public static ParkingSpaceDTO toDTO(ParkingSpace entity) {
        if (entity == null) return null;
        ParkingSpaceDTO dto = new ParkingSpaceDTO();
        dto.setSpaceId(entity.getSpaceId());
        dto.setStatus(entity.getStatus());
        dto.setSpaceIdentifier(entity.getSpaceIdentifier());
        dto.setLocation(entity.getLocation());
        dto.setPricePerHour(entity.getPricePerHour());
        dto.setOwnerId(entity.getOwnerId());
        return dto;
    }

    public static ParkingSpace toEntity(ParkingSpaceDTO dto) {
        if (dto == null) return null;
        ParkingSpace entity = new ParkingSpace();
        entity.setSpaceId(dto.getSpaceId());
        entity.setStatus(dto.getStatus());
        entity.setSpaceIdentifier(dto.getSpaceIdentifier());
        entity.setLocation(dto.getLocation());
        entity.setPricePerHour(dto.getPricePerHour());
        entity.setOwnerId(dto.getOwnerId());
        return entity;
    }
}
