package org.afs.pakinglot.domain;

import org.afs.pakinglot.domain.exception.UnrecognizedTicketException;
import org.afs.pakinglot.domain.strategies.AvailableRateStrategy;
import org.afs.pakinglot.domain.strategies.MaxAvailableStrategy;
import org.afs.pakinglot.domain.strategies.SequentiallyStrategy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ParkingLotManager {
    private List<ParkingLot> parkingLots;
    private Map<String, ParkingBoy> parkingBoyTypeToParkingBoyMap;

    public ParkingLotManager() {
        ParkingLot plazaPark = new ParkingLot(1, "Plaza Park", 9);
        ParkingLot cityMallGarage = new ParkingLot(2, "City Mall Garage", 12);
        ParkingLot officeTowerParking = new ParkingLot(3, "Office Tower Parking", 9);

        parkingLots = Arrays.asList(plazaPark, cityMallGarage, officeTowerParking);

        ParkingBoy standardParkingBoy = new ParkingBoy(parkingLots, new SequentiallyStrategy());
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots, new MaxAvailableStrategy());
        ParkingBoy superSmartParkingBoy = new ParkingBoy(parkingLots, new AvailableRateStrategy());

        parkingBoyTypeToParkingBoyMap = new HashMap<>();
        parkingBoyTypeToParkingBoyMap.put("Standard", standardParkingBoy);
        parkingBoyTypeToParkingBoyMap.put("Smart", smartParkingBoy);
        parkingBoyTypeToParkingBoyMap.put("Super Smart", superSmartParkingBoy);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Ticket parkCar(String plateNumber, String parkingBoyType) {
        ParkingBoy parkingBoy = parkingBoyTypeToParkingBoyMap.get(parkingBoyType);
        if (parkingBoy == null) {
            throw new IllegalArgumentException("Invalid parking boy type");
        }
        if (!plateNumber.matches("^[A-Z]{2}-\\d{4}$")) {
            throw new IllegalArgumentException("Invalid plate number format");
        }
        Car car = new Car(plateNumber);
        return parkingBoy.park(car);
    }

    public Car fetchCar(String plateNumber) {
        for (ParkingLot parkingLot : parkingLots) {
            Ticket ticket = parkingLot.getTickets().stream()
                    .filter(currentTicket -> currentTicket.plateNumber().equals(plateNumber))
                    .findFirst()
                    .orElseThrow(UnrecognizedTicketException::new);
            return parkingLot.fetch(ticket);
        }
        throw new UnrecognizedTicketException();
    }
}