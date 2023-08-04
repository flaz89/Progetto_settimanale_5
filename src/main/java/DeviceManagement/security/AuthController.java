package DeviceManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import DeviceManagement.entities.user.User;
import DeviceManagement.entities.user.UserBodyRequest;
import DeviceManagement.entities.user.UserService;

@RestController
@RequestMapping("/home")
public class AuthController {
	
	@Autowired
	private UserService userSrv;
	
	
	@GetMapping("/prova")
	public String prova() {
		return "richiesta GET effettuata";
	}
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUser(@RequestBody UserBodyRequest user){
		System.out.println("Utente registrato con successo: \n" + user);
		return userSrv.saveUser(user);
	}
}
