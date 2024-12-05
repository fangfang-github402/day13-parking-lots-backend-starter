package org.afs.pakinglot.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingLotManagerTest {
//Background: As a Parking Manager, I am responsible for managing three parking lots: ● The Plaza Park (9 parking capacity) ● City Mall Garage (12 parking capacity) ● Office Tower Parking (9 parking capacity) I have employed three Parking Boys to help manage these parking lots, each utilizing a specific parking strategy:
//Standard parking strategy
//Smart parking strategy
//Super Smart parking strategy To optimize management and streamline operations, I need an application that assists me in visualizing and efficiently managing

    private ParkingLotManager parkingLotManager;
    private String plateNumber;

    @BeforeEach
    void setUp() {
        parkingLotManager = new ParkingLotManager();
        plateNumber = "ABC-123";
    }

    @Test
    void shouldParkCarWhenUsingStandardParkingBoyGivenPlateNumber() {
        // Act
        Ticket ticket = parkingLotManager.parkCar(plateNumber, "Standard");

        // Assert
        assertNotNull(ticket);
    }

    @Test
    void shouldParkCarWhenUsingSmartParkingBoyGivenPlateNumber() {
        // Act
        Ticket ticket = parkingLotManager.parkCar(plateNumber, "Smart");

        // Assert
        assertNotNull(ticket);
    }

    @Test
    void shouldParkCarWhenUsingSuperSmartParkingBoyGivenPlateNumber() {
        // Act
        Ticket ticket = parkingLotManager.parkCar(plateNumber, "SuperSmart");

        // Assert
        assertNotNull(ticket);
    }

    @Test
    void shouldFetchCarWhenUsingStandardParkingBoyGivenValidPlateNumber() {
        // Arrange
        parkingLotManager.parkCar(plateNumber, "Standard");

        // Act
        Car fetchedCar = parkingLotManager.fetchCar(plateNumber);

        // Assert
        assertEquals(new Car(plateNumber), fetchedCar);
    }

    @Test
    void shouldFetchCarWhenUsingSmartParkingBoyGivenValidPlateNumber() {
        // Arrange
        parkingLotManager.parkCar(plateNumber, "Smart");

        // Act
        Car fetchedCar = parkingLotManager.fetchCar(plateNumber);

        // Assert
        assertEquals(new Car(plateNumber), fetchedCar);
    }

    @Test
    void shouldFetchCarWhenUsingSuperSmartParkingBoyGivenValidPlateNumber() {
        // Arrange
        parkingLotManager.parkCar(plateNumber, "SuperSmart");

        // Act
        Car fetchedCar = parkingLotManager.fetchCar(plateNumber);

        // Assert
        assertEquals(new Car(plateNumber), fetchedCar);
    }
}