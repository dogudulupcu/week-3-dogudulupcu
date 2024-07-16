package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserRepository {

    private List<User> userList = new ArrayList<>();



    public void save(User user) {
        userList.add(user);
    }

    public List<User> getAll() {
        return userList;
    }

    public Optional<User> findByEmail(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();

    }

    public Optional<User> findById(long id) {
        return userList.stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst();
    }

    public void delete(User user) {
        userList.remove(user);
    }

    public void loadData() {

        // create 10 random user
       // User user = new User("Ali", "Veli", "aliveli@gmail.com", "1234567890", "5309434390",true);
       // User user2 = new User("Cem", "drman", "cemdrman@gmail.com", "9876543210", "5321234567", false);
       // User user3 = new User("Ayşe", "Kaya", "aysekaya@gmail.com", "4561237890", "5359876543", true);
       // User user4 = new User("Mehmet", "Öztürk", "mehmetozturk@gmail.com", "6547893210", "5315678901", false);
        //add users
      //  userList.addAll(List.of(user, user2, user3, user4));
    }
}
