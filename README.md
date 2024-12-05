Background: As a Parking Manager, I am responsible for managing three parking lots: ● The Plaza Park (9 parking capacity) ● City Mall Garage (12 parking capacity) ● Office Tower Parking (9 parking capacity) I have employed three Parking Boys to help manage these parking lots, each utilizing a specific parking strategy:
Standard parking strategy
Smart parking strategy
Super Smart parking strategy To optimize management and streamline operations, I need an application that assists me in visualizing and efficiently managing   
请帮我编写ParkingLotManager.java

请帮我用should_xx_when_xx_given_xx命名方式编写测试，需要包括选择不同parking boy的停车取车等不同场景

public Ticket parkCar(Car car, String parkingBoyType) { ParkingBoy parkingBoy = parkingBoyMap.get(parkingBoyType); if (parkingBoy == null) { throw new IllegalArgumentException("Invalid parking boy type"); } return parkingBoy.park(car); } 需要把参数car改成String plateNumber  

请帮我park方法编写对应的service