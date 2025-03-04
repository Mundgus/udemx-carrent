package hu.mundgus.udemxcarrent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;

import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
            nullable = false,
            unique = true,
            length = 32
    )
    private String plateNumber;

    @Column(
            nullable = false
    )
    private Integer dailyFee;

    @Column(
            nullable = false
    )
    private String fuelType;

    @Column(
            nullable = false
    )
    private Integer fuelConsumption;

    @Column(
            nullable = false
    )
    private Boolean isActive;

    private String description;

    @OneToMany(
            mappedBy = "car"
    )
    private List<CarImage> carImages;

    @OneToMany(
            mappedBy = "car"
    )
    private List<Booking> bookings;


    public Car() {}

    public Car(Integer id, String plateNumber, Integer dailyFee, String fuelType, Integer fuelConsumption, Boolean isActive, String description) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.dailyFee = dailyFee;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.isActive = isActive;
        this.description = description;
    }
}
