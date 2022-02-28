package cz.upce.fei.nnpiacv03.users;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsersServiceImpl implements UsersService {
    private final HashMap<Integer, User> userHashMap;

    public UsersServiceImpl(){
        userHashMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userHashMap.put(user.getUserId(), user);
    }

    @Override
    public User getUser(Integer id) {
        if (userHashMap.containsKey(id)){
            return userHashMap.get(id);
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userHashMap.values());
    }
}
