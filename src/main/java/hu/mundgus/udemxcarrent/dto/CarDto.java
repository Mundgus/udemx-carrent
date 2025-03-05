package hu.mundgus.udemxcarrent.dto;

import java.util.List;


public class CarDto {
    private Integer id;
    private String name;
    private String plateNumber;
    private Integer dailyFee;
    private String fuelType;
    private Double fuelConsumption;
    private Boolean isActive;
    private String description;
    private List<CarImageDto> images;

    public CarDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
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

    public List<CarImageDto> getImages() {
        return images;
    }

    public void setImages(List<CarImageDto> images) {
        this.images = images;
    }

}
