package repository.user;

import models.User;
import models.enums.Department;

import java.util.List;

public interface UserRepository {
    User addUser(String name, Department department);
    User getUser(long id);
    List<User> getAllUsers();
}
