package org.afs.pakinglot.domain;

import static org.junit.jupiter.api.Assertions.*;
//Background: As a Parking Manager, I am responsible for managing three parking lots: ● The Plaza Park (9 parking capacity) ● City Mall Garage (12 parking capacity) ● Office Tower Parking (9 parking capacity) I have employed three Parking Boys to help manage these parking lots, each utilizing a specific parking strategy:
//Standard parking strategy
//Smart parking strategy
//Super Smart parking strategy To optimize management and streamline operations, I need an application that assists me in visualizing and efficiently managing
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingLotManagerTest {

    private ParkingLotManager parkingLotManager;
    private Car car;

    @BeforeEach
    void setUp() {
        parkingLotManager = new ParkingLotManager();
        car = new Car("ABC-123");
    }

    @Test
    void shouldParkCarWhenUsingStandardParkingBoyGivenCar() {
        // Act
        Ticket ticket = parkingLotManager.parkCar(car, "Standard");

        // Assert
        assertNotNull(ticket);
    }

    @Test
    void shouldParkCarWhenUsingSmartParkingBoyGivenCar() {
        // Act
        Ticket ticket = parkingLotManager.parkCar(car, "Smart");

        // Assert
        assertNotNull(ticket);
    }

    @Test
    void shouldParkCarWhenUsingSuperSmartParkingBoyGivenCar() {
        // Act
        Ticket ticket = parkingLotManager.parkCar(car, "SuperSmart");

        // Assert
        assertNotNull(ticket);
    }

    @Test
    void shouldFetchCarWhenUsingStandardParkingBoyGivenValidTicket() {
        // Arrange
        Ticket ticket = parkingLotManager.parkCar(car, "Standard");

        // Act
        Car fetchedCar = parkingLotManager.fetchCar(ticket);

        // Assert
        assertEquals(car, fetchedCar);
    }

    @Test
    void shouldFetchCarWhenUsingSmartParkingBoyGivenValidTicket() {
        // Arrange
        Ticket ticket = parkingLotManager.parkCar(car, "Smart");

        // Act
        Car fetchedCar = parkingLotManager.fetchCar(ticket);

        // Assert
        assertEquals(car, fetchedCar);
    }

    @Test
    void shouldFetchCarWhenUsingSuperSmartParkingBoyGivenValidTicket() {
        // Arrange
        Ticket ticket = parkingLotManager.parkCar(car, "SuperSmart");

        // Act
        Car fetchedCar = parkingLotManager.fetchCar(ticket);

        // Assert
        assertEquals(car, fetchedCar);
    }
}