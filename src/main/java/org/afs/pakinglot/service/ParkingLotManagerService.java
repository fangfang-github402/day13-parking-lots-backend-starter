package org.afs.pakinglot.service;

import org.afs.pakinglot.domain.Car;
import org.afs.pakinglot.domain.ParkingLot;
import org.afs.pakinglot.domain.ParkingLotManager;
import org.afs.pakinglot.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotManagerService {

    private final ParkingLotManager parkingLotManager;

    @Autowired
    public ParkingLotManagerService(ParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    public List<ParkingLot> getParkingLots() {
    return parkingLotManager.getParkingLots();
}

    public Ticket parkCar(String plateNumber, String parkingBoyType) {
        return parkingLotManager.parkCar(plateNumber, parkingBoyType);
    }

    public Car fetchCar(String plateNumber) {
        return parkingLotManager.fetchCar(plateNumber);
    }
}