package hu.mundgus.udemxcarrent.model;

import jakarta.persistence.*;

@Entity
@Table
public class Location {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            nullable = false
    )
    private String country;

    private String county;

    @Column(
            nullable = false,
            length = 10
    )
    private String postalCode;

    @Column(
            nullable = false
    )
    private String city;

    @Column(
            nullable = false
    )
    private String streetName;

    @Column(
            nullable = false
    )
    private String streetNumber;

    @OneToOne(
            mappedBy = "location"
    )
    private User user;

    public Location() {
    }

    public Location(Integer id, String country, String county, String postalCode, String city, String streetName, String streetNumber, User user) {
        this.id = id;
        this.country = country;
        this.county = county;
        this.postalCode = postalCode;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.user = user;
    }
}
