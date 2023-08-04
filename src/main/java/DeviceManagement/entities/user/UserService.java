package DeviceManagement.entities.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DeviceManagement.entities.device.Device;
import DeviceManagement.entities.device.DeviceRepository;
import DeviceManagement.entities.device.DeviceStatus;
import Exceptions.NotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private DeviceRepository devRepo;
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public User saveUser(UserBodyRequest user) {
		User newUser = new User(user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
		return userRepo.save(newUser);
	}
	
	public User findById(UUID userId) throws NotFoundException {
		return userRepo.findById(userId).orElseThrow(() -> new NotFoundException(userId));
	}
	
	public User updateUserbyId(UserBodyRequest user, UUID userId) {
		User userFound = userRepo.findById(userId).orElseThrow(() -> new NotFoundException(userId));
		userFound.setName(user.getName());
		userFound.setSurname(user.getSurname());
		userFound.setEmail(user.getEmail());
		userFound.setPassword(user.getPassword());
		return userRepo.save(userFound);
	}
	
	public void deleteUser(UUID userId) {
		userRepo.deleteById(userId);
	}
	
	public void addDeviceToUser(UUID userId, int devId) {
		User userFound = userRepo.findById(userId).orElseThrow(() -> new NotFoundException(userId));
		Device devFound = devRepo.findById(devId).orElseThrow(() -> new NotFoundException(devId));
		devFound.setUser(userFound);
		devFound.setStatus(DeviceStatus.ASSIGNED);
		userFound.getDevices().add(devFound);
		userRepo.save(userFound);
	}
}
