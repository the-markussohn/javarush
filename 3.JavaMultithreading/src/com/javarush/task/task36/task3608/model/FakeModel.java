package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justinas on 2017-10-14.
 */
public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("A", 1, 1));
        list.add(new User("B", 2, 1));
        list.add(new User("C", 3, 1));
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
