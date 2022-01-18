package com.example.loginos.model;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.ArrayList;

public class UserRepository {
    private static UserRepository self;
    private ArrayList<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("teszt@teszt.com", DigestUtils.md2Hex("teszt")));
    }

    public static UserRepository getInstance() {
        if(self == null)
        {
            self = new UserRepository();
        }
        return self;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User findUserByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }
}
