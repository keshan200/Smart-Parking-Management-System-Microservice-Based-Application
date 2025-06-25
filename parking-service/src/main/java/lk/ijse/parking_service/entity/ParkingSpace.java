package lk.ijse.parking_service.entity;


import jakarta.persistence.*;
import lk.ijse.parking_service.enums.SpaceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spaceId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpaceStatus status;

    @Column(nullable = false)
    private String spaceIdentifier;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private BigDecimal pricePerHour;

    @Column(nullable = false)
    private Long ownerId;
}
