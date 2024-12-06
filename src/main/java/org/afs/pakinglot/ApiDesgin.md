# API Design Document

## Overview
This document outlines the API design for the Parking Lot Management System. The system allows users to park and fetch cars, as well as retrieve information about all parking lots.

## Base URL
`http://localhost:8080/parking`

## Endpoints

### 1. Get All Parking Lots
- **URL**: `/lots`
- **Method**: `GET`
- **Description**: Retrieves a list of all parking lots.
- **Response**:
    - **Status**: `200 OK`
    - **Body**:
      ```json
      [
        {
          "name": "Parking Lot 1",
          "capacity": 100,
          "tickets": [
            {
                "plateNumber": "AB-5566",
                "position": 1,
                "parkingLot": 1
            },
            {
                "plateNumber": "QQ-1234",
                "position": 3,
                "parkingLot": 1
            }]
        },
        {
          "name": "Parking Lot 2",
          "capacity": 150,
          "tickets": []
        }
      ]
      ```

### 2. Park a Car
- **URL**: `/park`
- **Method**: `POST`
- **Description**: Parks a car using the provided plate number and parking boy type.
- **Request Body**:
  ```json
  {
    "plateNumber": "ABC-123",
    "parkingBoyType": "Standard"
  }
- **Response**:
    - **Status**: `200 OK`
    - **Body**:
      ```json
      {
        "plateNumber": "ABC-123",
        "position": 1,
        "parkingLot": 1
      }
      ```

  ### 3. Fetch a Car
- **URL**: `/fetch`
- **Method**: `GET`
- **Description： Fetches a car using the provided plate number.
- **Request Parameters**: `plateNumber
- **Response**:
    - **Status**: `200 OK`
    - **Body**:
      ```json
      {
        "plateNumber": "ABC-123"
      }
      ```