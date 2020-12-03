package com.example.lr4.services;

import com.example.lr4.dao.UserDao;
import com.example.lr4.models.Messages;
import com.example.lr4.models.Users;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public Users findUser(int id) {
        return usersDao.findUserById(id);
    }

    public void saveUser(Users user) {
        usersDao.save(user);
    }

    public void deleteUser(Users user) {
        usersDao.delete(user);
    }

    public void updateUser(Users user) {
        usersDao.update(user);
    }

    public List<Users> findAllUsers() {
        return usersDao.findAll();
    }

    public Messages findMessage(int id) {
        return usersDao.findMessageById(id);
    }

}
