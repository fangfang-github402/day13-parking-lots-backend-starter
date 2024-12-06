package org.afs.pakinglot.service;

import org.afs.pakinglot.domain.Car;
import org.afs.pakinglot.domain.ParkingLot;
import org.afs.pakinglot.domain.ParkingLotManager;
import org.afs.pakinglot.domain.Ticket;
import org.afs.pakinglot.dto.ParkingLotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotManagerService {

    private final ParkingLotManager parkingLotManager;

    @Autowired
    public ParkingLotManagerService(ParkingLotManager parkingLotManager) {
        this.parkingLotManager = parkingLotManager;
    }

    public List<ParkingLotDto> getParkingLots() {
    return mapParkingLotToDto(parkingLotManager.getParkingLots());
}

    public List<ParkingLotDto> mapParkingLotToDto(List<ParkingLot> parkingLots) {
        return parkingLots.stream().map(parkingLot -> new ParkingLotDto(parkingLot.getName(), parkingLot.getCapacity(), parkingLot.getTickets())).collect(Collectors.toList());
    }

    public Ticket parkCar(String plateNumber, String parkingBoyType) {
        return parkingLotManager.parkCar(plateNumber, parkingBoyType);
    }

    public Car fetchCar(String plateNumber) {
        return parkingLotManager.fetchCar(plateNumber);
    }
}