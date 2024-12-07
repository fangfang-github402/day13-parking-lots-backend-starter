package org.afs.pakinglot.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.afs.pakinglot.domain.exception.NoAvailablePositionException;
import org.afs.pakinglot.domain.exception.UnrecognizedTicketException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingLotManagerTest {
    private ParkingLotManager parkingLotManager;
    private String plateNumber;

    @BeforeEach
    void setUp() {
        parkingLotManager = new ParkingLotManager();
        plateNumber = "AB-1723";
    }

    @Test
    void should_return_ticket_when_park_given_plate_number_and_standard_parking_boy() {
        // Given
        // When
        Ticket ticket = parkingLotManager.parkCar(plateNumber, "Standard");
        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_park_car_given_plate_number_and_smart_parking_boy() {
        // Given
        // When
        Ticket ticket = parkingLotManager.parkCar(plateNumber, "Smart");
        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_when_park_car_given_plate_number_and_super_smart_parking_boy() {
        // Given
        // When
        Ticket ticket = parkingLotManager.parkCar(plateNumber, "Super Smart");
        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_valid_plate_number() {
        // Given
        parkingLotManager.parkCar(plateNumber, "Standard");
        // When
        Car fetchedCar = parkingLotManager.fetchCar(plateNumber);
        // Then
        assertEquals(new Car(plateNumber), fetchedCar);
    }

    @Test
    void should_throw_exception_when_fetch_given_invalid_plate_number() {
        // Given
        parkingLotManager.parkCar(plateNumber, "Standard");
        // When
        // Then
        assertThrows(UnrecognizedTicketException.class, () -> parkingLotManager.fetchCar("DEF-456"));
    }

    @Test
    void should_throw_exception_when_park_given_invalid_plate_number() {
        // Given
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> parkingLotManager.parkCar("ABC-1234", "Standard"));
    }

    @Test
    void should_throw_exception_when_park_given_invalid_parking_boy_type() {
        // Given
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> parkingLotManager.parkCar(plateNumber, "Invalid"));
    }

    @Test
    void should_throw_exception_when_park_given_no_available_parking_lot() {
        // Given
        for(int i = 0; i < 30; i++) {
            parkingLotManager.parkCar("AB-" + String.format("%04d", i), "Standard");
        }
        // When
        // Then
        assertThrows(NoAvailablePositionException.class, () -> parkingLotManager.parkCar(plateNumber, "Standard"));
    }
}