package hu.mundgus.udemxcarrent.dto;

import hu.mundgus.udemxcarrent.model.Car;

import java.time.LocalDate;


public class BookingDto {
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    private CarDto car;
    private UserDto user;

    public BookingDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
