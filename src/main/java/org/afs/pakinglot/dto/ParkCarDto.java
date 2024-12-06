package org.afs.pakinglot.dto;

public class ParkCarDto {
    private String plateNumber;
    private String parkingBoyType;

    public ParkCarDto(String plateNumber, String parkingBoyType) {
        this.plateNumber = plateNumber;
        this.parkingBoyType = parkingBoyType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getParkingBoyType() {
        return parkingBoyType;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setParkingBoyType(String parkingBoyType) {
        this.parkingBoyType = parkingBoyType;
    }
}
