package cz.upce.fei.nnpiacv03.users;

import java.util.List;

public interface UsersService {
    void addUser(User user);
    User getUser(Integer id);
    List<User> getAllUsers();
}
