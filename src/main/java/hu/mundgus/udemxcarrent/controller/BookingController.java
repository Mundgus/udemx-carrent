package hu.mundgus.udemxcarrent.controller;

import hu.mundgus.udemxcarrent.dto.BookingDto;
import hu.mundgus.udemxcarrent.dto.CarDto;
import hu.mundgus.udemxcarrent.dto.UserDto;
import hu.mundgus.udemxcarrent.model.Booking;
import hu.mundgus.udemxcarrent.model.Car;
import hu.mundgus.udemxcarrent.model.User;
import hu.mundgus.udemxcarrent.repository.BookingRepository;
import hu.mundgus.udemxcarrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/api/bookings")
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::toBookingDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/bookings")
    public BookingDto createBooking(
            @RequestBody BookingDto bookingDto
    ) {
        Booking booking = new Booking();
        booking.setStartDate(bookingDto.getStartDate());
        booking.setEndDate(bookingDto.getEndDate());

        Car car = toCar(bookingDto.getCar());
        booking.setCar(car);

        User user = toUser(bookingDto.getUser());
        userRepository.save(user);
        booking.setUser(user);

        bookingRepository.save(booking);
        return bookingDto;
    }

    private BookingDto toBookingDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();

        bookingDto.setId(booking.getId());
        bookingDto.setStartDate(booking.getStartDate());
        bookingDto.setEndDate(booking.getEndDate());

        UserDto userDto = new UserDto();
        userDto.setFullName(booking.getUser().getFullName());
        userDto.setEmail(booking.getUser().getEmail());
        userDto.setPhone(booking.getUser().getPhone());
        userDto.setLocation(booking.getUser().getLocation());
        bookingDto.setUser(userDto);

        CarDto carDto = new CarDto();
        carDto.setName(booking.getCar().getName());
        carDto.setPlateNumber(booking.getCar().getPlateNumber());
        bookingDto.setCar(carDto);

        return bookingDto;
    }

    private Car toCar(CarDto carDto) {
        Car car = new Car();

        car.setId(carDto.getId());

        return car;
    }

    private User toUser(UserDto userDto) {
        User user = new User();

        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setLocation(userDto.getLocation());

        return user;
    }
}