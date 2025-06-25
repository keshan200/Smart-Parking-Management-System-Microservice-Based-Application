package lk.ijse.vehicle_service.dto;

public class VehicleDTO {

    private Long id;

    private String licensePlate;

    private String model;

    private String ownerId;

    private boolean isParked;

    public VehicleDTO() {}

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
