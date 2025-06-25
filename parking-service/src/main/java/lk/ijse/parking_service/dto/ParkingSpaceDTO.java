package lk.ijse.parking_service.dto;


import lk.ijse.parking_service.enums.SpaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpaceDTO {
    private Long spaceId;
    private SpaceStatus status;
    private String spaceIdentifier;
    private String location;
    private BigDecimal pricePerHour;
    private Long ownerId;
}
