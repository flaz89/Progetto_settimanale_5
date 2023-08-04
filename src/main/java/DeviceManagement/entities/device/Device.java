package DeviceManagement.entities.device;

import DeviceManagement.entities.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Device {
	@Id
	@GeneratedValue
	private int id;
	
	private String model;
	@Enumerated(EnumType.STRING)
	private DeviceType type;
	@Enumerated(EnumType.STRING)
	private DeviceStatus status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Device(String model, DeviceType type, DeviceStatus status) {
		this.model = model;
		this.type = type;
		this.status = status;
	}
}
