package lk.ijse.vehicle_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;

    private String model;

    private String ownerId; // Link vehicle to user by userId

    private boolean isParked;  // For entry/exit simulation

    public Vehicle() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public boolean isParked() { return isParked; }
    public void setParked(boolean parked) { isParked = parked; }
}
