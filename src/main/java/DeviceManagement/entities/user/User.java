package DeviceManagement.entities.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
