package com.elsafty.maidscc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
/**
 * Service class for managing Device entities.
 */
@Service
public class DeviceService {
 
    private final DeviceRepository DeviceRepository;
 
    @Autowired
    public DeviceService(DeviceRepository DeviceRepository) {
        this.DeviceRepository = DeviceRepository;
    }
 
    /**
     * Save a Device.
     *
     * @param Device the entity to save
     * @return the persisted entity
     */
    public Device saveDevice(Device Device) {
        return DeviceRepository.save(Device);
    }
 
    /**
     * Get all the Devices.
     *
     * @return the list of entities
     */
    public List<Device> getAllDevices() {
        return DeviceRepository.findAll();
    }
 
    /**
     * Get one Device by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Device> getDeviceById(Long id) {
        return DeviceRepository.findById(id);
    }
 
    /**
     * Update a Device.
     *
     * @param id the ID of the entity
     * @param updatedDevice the updated entity
     * @return the updated entity
     */
    // public Device updateDevice(Long id, Device updatedDevice) {
    //     Optional<Device> existingDevice = DeviceRepository.findById(id);
    //     if (existingDevice.isPresent()) {
    //         Device Device = existingDevice.get();
    //         Device.setName(updatedDevice.getName());
    //         Device.setPrice(updatedDevice.getPrice());
    //         Device.setQuantity(updatedDevice.getQuantity());
    //         return DeviceRepository.save(Device);
    //     } else {
    //         throw new RuntimeException("Device not found");
    //     }
    // }
 
    /**
     * Delete the Device by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteDevice(Long id) {
        DeviceRepository.deleteById(id);
    }
}