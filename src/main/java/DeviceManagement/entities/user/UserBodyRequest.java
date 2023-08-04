package DeviceManagement.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserBodyRequest {
	private String name;
	private String surname;
	private String email;
	private String password;
}
