package hu.mundgus.udemxcarrent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "car_images")
public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
            nullable = false
    )
    private Integer rank;

    @Column(
            nullable = false
    )
    private String imageUrl;

    @ManyToOne
    @JoinColumn(
            name = "car_id",
            nullable = false
    )
    private Car car;
}
