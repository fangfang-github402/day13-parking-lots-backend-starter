package org.afs.pakinglot.controller;

import org.afs.pakinglot.domain.Car;
import org.afs.pakinglot.domain.ParkingLot;
import org.afs.pakinglot.domain.Ticket;
import org.afs.pakinglot.service.ParkingLotManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingLotManagerController {

    private final ParkingLotManagerService parkingLotManagerService;

    @Autowired
    public ParkingLotManagerController(ParkingLotManagerService parkingLotManagerService) {
        this.parkingLotManagerService = parkingLotManagerService;
    }

    @GetMapping("/lots")
    public ResponseEntity<List<ParkingLot>> getParkingLots() {
        List<ParkingLot> parkingLots = parkingLotManagerService.getParkingLots();
        return ResponseEntity.ok(parkingLots);
    }

    @PostMapping("/park")
    public ResponseEntity<Ticket> parkCar(@RequestParam String plateNumber, @RequestParam String parkingBoyType) {
        Ticket ticket = parkingLotManagerService.parkCar(plateNumber, parkingBoyType);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/fetch")
    public ResponseEntity<Car> fetchCar(@RequestParam String plateNumber) {
        Car car = parkingLotManagerService.fetchCar(plateNumber);
        return ResponseEntity.ok(car);
    }

}