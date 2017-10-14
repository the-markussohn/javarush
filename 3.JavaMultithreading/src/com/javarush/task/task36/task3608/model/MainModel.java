package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by Justinas on 2017-10-15.
 */
public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    private List<User> getAllUsers() {
        List<User> usersBetweenLevels = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(usersBetweenLevels);
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> activeUsers = getAllUsers();
        modelData.setUsers(activeUsers);
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
    }
}
