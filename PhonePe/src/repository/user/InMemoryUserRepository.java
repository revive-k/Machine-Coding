package repository.user;

import models.User;
import models.enums.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository{
    private final Map<Long, User> users = new HashMap<>();
    @Override
    public User addUser(String name, Department department) {
        User user = new User(UserIdGenerator.generateUserId(), name, department);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUser(long id) {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
