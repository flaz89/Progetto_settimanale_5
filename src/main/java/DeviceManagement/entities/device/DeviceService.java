package DeviceManagement.entities.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.NotFoundException;

@Service
public class DeviceService {
	
	@Autowired
	public DeviceRepository devRepo;
	
	public List<Device> getAllDevices() {
		return devRepo.findAll();
	}
	
	public Device addDevice(Device dev) {
		Device newDev = new Device(dev.getModel(), dev.getType(), dev.getStatus());
		return devRepo.save(newDev);
	}
	
	public Device searchDeviceById(int devId) throws NotFoundException {
		return devRepo.findById(devId).orElseThrow(() -> new NotFoundException(devId));
	}
	
	public Device updateDeviceById(Device dev, int devId) {
		Device devFound = devRepo.findById(devId).orElseThrow(() -> new NotFoundException(devId));
		devFound.setType(dev.getType());
		devFound.setStatus(dev.getStatus());
		return devRepo.save(devFound);
	}
	
	public void deleteDeviceById(int devId) {
		devRepo.deleteById(devId);
	}
}
