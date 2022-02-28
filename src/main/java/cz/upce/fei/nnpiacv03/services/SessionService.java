package cz.upce.fei.nnpiacv03.services;

import cz.upce.fei.nnpiacv03.users.User;

public interface SessionService {
    User getUser();
    void setUser(User user);
}
