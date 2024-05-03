# Devices Price Classification System

This project implements a Devices Price Classification System, consisting of a Python API for price prediction and a Spring Boot application for managing device data and providing RESTful endpoints.

## Overview

The system is designed to predict the price range of devices based on their specifications. It consists of two main components:

1. **Python API (Price Prediction)**:
   - Implements a machine learning model to predict the price range of devices.
   - Exposes an HTTP endpoint to receive device specifications and return the predicted price range.
   - Built using the Flask framework.

2. **Spring Boot Application**:
   - Manages device data using a MySQL database.
   - Provides RESTful endpoints for CRUD operations on devices.
   - Communicates with the Python API to predict device prices.
   - Utilizes Spring Data JPA for data access and management.

## Architecture
            +-------------------------------------------------------+
            |               Devices Price Classification            |
            |                System Architecture                    |
            +-------------------------------------------------------+
                           |                         |                       
                           |                         |                       
                           |                         |                       
                           v                         v                       
                     +------------------+      +-----------------+             
                     |   Python API     |      | Spring Boot App |             
                     |(Price Prediction)|      | (Device Manager)|             
                     |      (Flask)     |      |  (Spring Boot)  |             
                     +------------------+      +-----------------+             
                           |                         |                       
                           |    HTTP Requests        |                       
                           |------------------------>|                       
                           |                         |                       
                           |    HTTP Responses       |                       
                           |<------------------------|                       
                           |                         |                       
                           v                         v                       
                     +-----------------+      +-----------------+             
                     |   Machine       |      |   MySQL         |             
                     | Learning Model  |      |   Database      |             
                     |   (Python)      |      |(Spring Data JPA)|             
                     +-----------------+      +-----------------+             
                                      



## Getting Started

To run the project locally, follow these steps:

1. **Set up Python API**:
   - Navigate to the `python_api` directory.
   - Install the required Python dependencies by running `pip install -r requirements.txt`.
   - Run the Flask application using `python app.py`.
   - The API will start running on `http://localhost:5000`.

2. **Set up Spring Boot Application**:
   - Import the project into your preferred IDE (Eclipse, IntelliJ, etc.).
   - Configure the MySQL database connection details in the `application.properties` file.
   - Run the Spring Boot application.
   - The application will start running on `http://localhost:8080`.

3. **Access Endpoints**:
   - Use a tool like Postman to send HTTP requests to the Spring Boot application's endpoints.
   - Manage devices and make price predictions using the provided endpoints.

## Endpoints

### Spring Boot Application

- `GET /api/devices/`: Retrieve a list of all devices.
- `GET /api/devices/{id}`: Retrieve details of a specific device by ID.
- `POST /api/devices/`: Add a new device.
- `PUT /api/devices/{id}`: Update an existing device.
- `DELETE /api/devices/{id}`: Delete a device.
- `POST /api/predict/{deviceId}`: Predict the price for a device with the given ID (calls the Python API).

### Python API

- `POST /predict`: Receive device specifications and return the predicted price range.

## Running the Application

To showcase the project, follow these steps:

1. Run both the Python API and Spring Boot Application as per the instructions above.
2. Use Postman or a similar tool to interact with the Spring Boot Application's endpoints.
3. Perform CRUD operations on devices using the respective endpoints (`GET /api/devices/`, `POST /api/devices/`, etc.).
4. To predict the price range for a device, send a `POST` request to `http://localhost:8080/api/predict/{deviceId}`, replacing `{deviceId}` with the ID of the device you want to predict the price for.
5. The Spring Boot Application will communicate with the Python API, which will use the machine learning model to predict the price range based on the device's specifications.
6. The predicted price range will be returned in the response from the Spring Boot Application.

By following these steps, you can demonstrate the end-to-end functionality of the Devices Price Classification System, showcasing the integration between the Spring Boot Application and the Python API, as well as the machine learning model's ability to predict device prices based on specifications.

## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvements, please open an issue or submit a pull request.
