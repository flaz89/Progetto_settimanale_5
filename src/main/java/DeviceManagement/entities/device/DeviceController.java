package DeviceManagement.entities.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/devices")
public class DeviceController {
	
	@Autowired
	private DeviceService devSrv;
	
	@GetMapping
	public List<Device> getAllDevices() {
		return devSrv.getAllDevices();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Device addDevice(@RequestBody Device dev) {
		//Device newDev = new Device(dev.getModel(), dev.getType(), dev.getStatus());
		return devSrv.addDevice(dev);
	}
	
	@GetMapping("/{devId}")
	public Device findDevById(@PathVariable int devId) {
		return devSrv.searchDeviceById(devId);
	}
	
	@PutMapping("/{devId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Device updateDeviceById(@RequestBody Device dev, @PathVariable int devId) {
		return devSrv.updateDeviceById(dev, devId);
	}
	
	@DeleteMapping("/{devId}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void deleteDevice(@PathVariable int devId) {
		devSrv.deleteDeviceById(devId);
	}
}
