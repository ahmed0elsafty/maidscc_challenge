package com.elsafty.maidscc;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/")
public class DeviceController {

	@Autowired
    private DeviceRepository deviceRepository;



    @GetMapping("/device")
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("device/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        return device.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device savedDevice = deviceRepository.save(device);
        return ResponseEntity.created(URI.create("/api/devices/" + savedDevice.getId())).body(savedDevice);
    }

     @PostMapping("/predict/{deviceId}")
    public ResponseEntity<String> predictAndSavePrice(@PathVariable Long deviceId) {
        // Fetch device details from the database
        Optional<Device> optionalDevice = deviceRepository.findById(deviceId);
        if (optionalDevice.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Device device = optionalDevice.get();

        // Prepare data for prediction (convert device object to JSON)
        ObjectMapper objectMapper = new ObjectMapper();
        String deviceJson;
        try {
            deviceJson = objectMapper.writeValueAsString(device);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing device data.");
        }

        // Make HTTP POST request to Python API
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(deviceJson, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity;
        try {
            responseEntity = restTemplate.exchange("http://localhost:5000/predict", HttpMethod.POST, requestEntity, String.class);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error communicating with Python API.");
        }

        // Check if prediction was successful
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Prediction failed.");
        }

        // Save prediction result in the database (if needed)
        // Apply transaction management

        // Return success response
        return ResponseEntity.ok("Prediction saved successfully."+responseEntity.getBody());
    }
}
