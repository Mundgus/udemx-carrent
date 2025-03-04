package hu.mundgus.udemxcarrent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
            nullable = false,
            length = 32
    )
    private String fullName;

    @Column(
            nullable = false
    )
    private String email;

    private String phone;

    @OneToMany(
            mappedBy = "user"
    )
    private List<Booking> bookings;


    @OneToOne
    @JoinColumn(
            name = "location_id",
            unique = true,
            nullable = false
    )
    private Location location;

    public User() {
    }

    public User(Integer id, String fullName, String email, String phone, List<Booking> bookings, Location location) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.bookings = bookings;
        this.location = location;
    }
}
