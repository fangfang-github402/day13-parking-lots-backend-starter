package org.afs.pakinglot.domain;


import org.afs.pakinglot.domain.exception.NoAvailablePositionException;
import org.afs.pakinglot.domain.exception.UnrecognizedTicketException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int id;
    private String name;
    private final Map<Ticket, Car> tickets = new HashMap<>();

    private static final int DEFAULT_CAPACITY = 10;
    private final int capacity;

    public ParkingLot() {
        this(DEFAULT_CAPACITY);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableCapacity() {
        return capacity - tickets.size();
    }

    public int findNextAvailablePosition() {
        return java.util.stream.IntStream.rangeClosed(1, capacity).filter(i -> tickets.keySet().stream().noneMatch(ticket -> ticket.position() == i)).findFirst().orElseThrow(NoAvailablePositionException::new);
    }

    public Ticket park(Car car) {
        if (isFull()) {
            throw new NoAvailablePositionException();
        }
        Ticket ticket = new Ticket(car.plateNumber(), findNextAvailablePosition(), this.id);
        tickets.put(ticket, car);
        return ticket;
    }

    public boolean isFull() {
        return capacity == tickets.size();
    }

    public Car fetch(Ticket ticket) {
        if (!tickets.containsKey(ticket)) {
            throw new UnrecognizedTicketException();
        }
        return tickets.remove(ticket);
    }

    public boolean contains(Ticket ticket) {
        return tickets.containsKey(ticket);
    }

    public double getAvailablePositionRate() {
        return getAvailableCapacity() / (double) capacity;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Ticket> getTickets() {
        return tickets.keySet().stream().toList();
    }

}
