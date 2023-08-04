package DeviceManagement.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UserBodyRequest {
	private String name;
	private String surname;
	private String email;
	private String password;
}
