# Devices Price Classification System

This project implements a Devices Price Classification System, consisting of a Python API for price prediction and a Spring Boot application for managing device data and providing RESTful endpoints.

## Architecture Overview

The system consists of two main components:

1. **Python API (Price Prediction)**:
   - Implements a machine learning model to predict the price range of devices based on their specifications.
   - Exposes an HTTP endpoint to receive device specifications and return the predicted price range.
   - Uses Flask framework for creating the API.
   - Trained using the provided dataset containing device specifications.

2. **Spring Boot Application**:
   - Manages device data using a MySQL database.
   - Provides RESTful endpoints to perform CRUD operations on devices.
   - Communicates with the Python API to predict device prices.
   - Uses Spring Data JPA for data access and management.

## Running the Project

To run the project, follow these steps:

1. **Set up Python API**:
   - Navigate to the `python_api` directory.
   - Install the required Python dependencies using `pip install -r requirements.txt`.
   - Run the Flask application using `python app.py`.
   - The API will start running on `http://localhost:5000`.

2. **Set up Spring Boot Application**:
   - Import the project into your preferred IDE (Eclipse, IntelliJ, etc.).
   - Configure the application properties (`application.properties`) with your MySQL database connection details.
   - Run the Spring Boot application.
   - The application will start running on `http://localhost:8080`.

3. **Accessing Endpoints**:
   - Use a tool like Postman to send HTTP requests to the Spring Boot application's endpoints (`http://localhost:8080/api/devices/`, etc.).
   - Use the provided endpoints to manage devices and make price predictions.

## Endpoints Documentation

### GET /api/devices/
- Retrieves a list of all devices.

### GET /api/devices/{id}
- Retrieves details of a specific device by ID.

### POST /api/devices/
- Adds a new device.

### POST /api/predict/{deviceId}
- Predicts the price for a device with the given ID.
- Calls the Python API to perform the prediction.

## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.
