package com.elsafty.maidscc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class DeviceController {

	private final DeviceService DeviceService;

	@Autowired
	public DeviceController(DeviceService DeviceService) {
		this.DeviceService = DeviceService;
	}

	/**
	* Create a new Device.
	*
	* @param Device the Device to create
	* @return the ResponseEntity with status 200 (OK) and with body of the new Device
	*/
	@PostMapping("/device")
	public ResponseEntity<Device> saveDevice(@RequestBody Device device) {
		Device newDevice = DeviceService.saveDevice(device);
		return ResponseEntity.ok(newDevice);
	}

	/**
	* Get all Devices.
	*
	* @return the ResponseEntity with status 200 (OK) and with body of the list of Devices
	*/
	@GetMapping("/devices")
	public List<Device> getAllDevices() {
		return DeviceService.getAllDevices();
	}

	/**
	* Get a Device by ID.
	*
	* @param id the ID of the Device to get
	* @return the ResponseEntity with status 200 (OK) and with body of the Device, or with status 404 (Not Found) if the Device does not exist
	*/
	@GetMapping("/devices/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
		Optional<Device> Device = DeviceService.getDeviceById(id);
		return Device.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	/**
	* Update a Device by ID.
	*
	* @param id the ID of the Device to update
	* @param Device the updated Device
	* @return the ResponseEntity with status 200 (OK) and with body of the updated Device, or with status 404 (Not Found) if the Device does not exist
	*/
	// @PutMapping("/devices/{id}")
	// public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device Device) {
	// 	Device updatedDevice = DeviceService.updateDevice(id, Device);
	// 	return ResponseEntity.ok(updatedDevice);
	// }

	/**
	* Delete a Device by ID.
	*
	* @param id the ID of the Device to delete
	* @return the ResponseEntity with status 200 (OK) and with body of the message "Device deleted successfully"
	*/
	@DeleteMapping("/devices/{id}")
	public ResponseEntity<String> deleteDevice(@PathVariable Long id) {
		DeviceService.deleteDevice(id);
		return ResponseEntity.ok("Device deleted successfully");
	}
}
