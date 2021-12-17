package crudApp.service;

import crudApp.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add (User user);
    void delete (int id);
    void edit (User user);
    User userById (int id);
    User getUserByName(String username);
}
