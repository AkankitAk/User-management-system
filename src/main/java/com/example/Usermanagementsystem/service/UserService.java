package com.example.Usermanagementsystem.service;

import com.example.Usermanagementsystem.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {
    static Map<Integer, User> userDataMap = new HashMap<>();

    public String addUser(User user) {
        userDataMap.put(user.getUserId(), user);
        return "Saved user with name- " + user.getUsername();
    }

    public List<User> getUser(Integer userId) {
        List<User> requiredUsersList = new ArrayList<>();
        if (null != userId) {
            if(userDataMap.containsKey(userId)) {
                requiredUsersList.add(userDataMap.get(userId));
            }
        }
        return requiredUsersList;
    }

    public String updateUser(User newUserData, Integer userId) {

        if(userDataMap.containsKey(userId)) {
            userDataMap.put(userId, newUserData);
            return "User data updated";
        } else {
            return "User not found";
        }
    }
    public String deleteUser(Integer userId) {

        if(userDataMap.containsKey(userId)) {
            userDataMap.remove(userId);
            return "User deleted with user Id" + userId;
        }
        else {
            return "User not found";
        }
    }

    public Map<Integer, User> getAllUser() {
        return userDataMap;
    }
}