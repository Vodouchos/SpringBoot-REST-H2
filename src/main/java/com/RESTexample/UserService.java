package com.RESTexample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User CreateUser(User user) {
		return userRepository.save(user);
	}

	public List<User> CreateUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	public User GetUserById(int id) {
		return userRepository.findById(id).orElseThrow();
	}

	public List<User> GetUsers() {
		return userRepository.findAll();
	}

	public User UpdateUser(User newUser) {
		int id = newUser.getId();
		return userRepository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setCountry(newUser.getCountry());
			return userRepository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return userRepository.save(newUser);
		});
	}

	public String RemoveUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		userRepository.deleteById(id);
		if (user.isPresent()) {
			return "User " + user.get().getName() + " was deleted";
		}
		return "User not found";
	}

}
