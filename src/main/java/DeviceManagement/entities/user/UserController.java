package DeviceManagement.entities.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import DeviceManagement.entities.device.Device;

@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserService userSrv;
	
	@GetMapping("/users")
	public List<User> getUser(){
		System.out.println("Lista Utenti:");
		List<User> userList = userSrv.getAllUser();
		for (User user : userList) {
			System.out.println(user);
		}
		return userList;
	}
	
	@GetMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	public User findUserById(@PathVariable UUID userId) {
		User userFound = userSrv.findById(userId);
		System.out.println("Utente trovato: " + userFound);
		return  userFound;
	}
	
	@PutMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	public User updateUserById(@RequestBody UserBodyRequest body, @PathVariable UUID userId) {
		return userSrv.updateUserbyId(body, userId);
	}
	
	@DeleteMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String deleteUserById(@PathVariable UUID userId) {
		User userFound = userSrv.findById(userId);
		userSrv.deleteUser(userId);
		return "Utente cancellato con successo: " + userFound;
	}
	
	@PutMapping("users/{userId}/{devId}")
	@ResponseStatus(HttpStatus.CREATED)
	public String addDeviceToUser(@PathVariable UUID userId, @PathVariable int devId) {
        userSrv.addDeviceToUser(userId, devId);
        return "Dispositivo aggiunto all'utente";
    }
}
