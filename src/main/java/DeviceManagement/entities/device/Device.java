package DeviceManagement.entities.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Device {
	@Id
	@GeneratedValue
	int id;
	
	DeviceType type;
	DeviceStatus status;
	
	public Device(DeviceType type, DeviceStatus status) {
		this.type = type;
		this.status = status;
	}
}
