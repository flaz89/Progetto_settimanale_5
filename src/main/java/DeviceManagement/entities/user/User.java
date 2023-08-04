package DeviceManagement.entities.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import DeviceManagement.entities.device.Device;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;
	private String surname;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Device> devices = new ArrayList<>();

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}
}
