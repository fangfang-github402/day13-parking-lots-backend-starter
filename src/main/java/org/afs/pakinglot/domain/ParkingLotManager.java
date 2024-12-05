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

//Background: As a Parking Manager, I am responsible for managing three parking lots: ● The Plaza Park (9 parking capacity) ● City Mall Garage (12 parking capacity) ● Office Tower Parking (9 parking capacity) I have employed three Parking Boys to help manage these parking lots, each utilizing a specific parking strategy:
//Standard parking strategy
//Smart parking strategy
//Super Smart parking strategy To optimize management and streamline operations, I need an application that assists me in visualizing and efficiently managing
@Component
public class ParkingLotManager {
    private List<ParkingLot> parkingLots;
    private List<ParkingBoy> parkingBoys;
    private Map<String, ParkingBoy> parkingBoyMap;

    public ParkingLotManager() {
        ParkingLot plazaPark = new ParkingLot(1,"Plaza Park", 9);
        ParkingLot cityMallGarage = new ParkingLot(2,"City Mall Garage", 12);
        ParkingLot officeTowerParking = new ParkingLot(3,"Office Tower Parking", 9);

        parkingLots = Arrays.asList(plazaPark, cityMallGarage, officeTowerParking);

        ParkingBoy standardParkingBoy = new ParkingBoy(parkingLots, new SequentiallyStrategy());
        ParkingBoy smartParkingBoy = new ParkingBoy(parkingLots, new MaxAvailableStrategy());
        ParkingBoy superSmartParkingBoy = new ParkingBoy(parkingLots, new AvailableRateStrategy());

        parkingBoys = Arrays.asList(standardParkingBoy, smartParkingBoy, superSmartParkingBoy);

        parkingBoyMap = new HashMap<>();
        parkingBoyMap.put("Standard", standardParkingBoy);
        parkingBoyMap.put("Smart", smartParkingBoy);
        parkingBoyMap.put("SuperSmart", superSmartParkingBoy);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Ticket parkCar(String plateNumber, String parkingBoyType) {
        ParkingBoy parkingBoy = parkingBoyMap.get(parkingBoyType);
        if (parkingBoy == null) {
            throw new IllegalArgumentException("Invalid parking boy type");
        }
        Car car = new Car(plateNumber);
        return parkingBoy.park(car);
    }

    public Car fetchCar(String plateNumber) {
        for (ParkingBoy parkingBoy : parkingBoys) {
            for (ParkingLot parkingLot : parkingBoy.parkingLots) {
                for (Ticket ticket : parkingLot.getTickets()) {
                    if (ticket.plateNumber().equals(plateNumber)) {
                        try {
                            return parkingBoy.fetch(ticket);
                        } catch (UnrecognizedTicketException e) {
                            // Continue to the next parking boy
                        }
                    }
                }
            }
        }
        throw new UnrecognizedTicketException();
    }
}