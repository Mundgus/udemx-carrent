package hu.mundgus.udemxcarrent.dto;

import jakarta.persistence.Column;

public class CarDto {
    private Integer id;
    private String plateNumber;
    private Integer dailyFee;
    private String fuelType;
    private Integer fuelConsumption;
    private Boolean isActive;
    private String description;

    public CarDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(Integer dailyFee) {
        this.dailyFee = dailyFee;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Integer fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
