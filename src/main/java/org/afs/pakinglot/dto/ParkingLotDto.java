package org.afs.pakinglot.dto;

import org.afs.pakinglot.domain.Ticket;

import java.util.List;

public class ParkingLotDto {
    private String name;
    private int capacity;
    private List<Ticket> tickets;

    public ParkingLotDto(String name, int capacity, List<Ticket> tickets) {
        this.name = name;
        this.capacity = capacity;
        this.tickets = tickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
