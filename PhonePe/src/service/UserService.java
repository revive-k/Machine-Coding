package service;

import models.User;
import models.enums.Department;
import repository.user.InMemoryUserRepository;
import repository.user.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String name, Department department) {
        return userRepository.addUser(name, department);
    }

    public User getUser(long id) {
        return userRepository.getUser(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}

