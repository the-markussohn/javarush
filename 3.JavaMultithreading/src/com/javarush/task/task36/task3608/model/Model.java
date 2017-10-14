package com.javarush.task.task36.task3608.model;

/**
 * Created by Justinas on 2017-10-14.
 */
public interface Model {
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();
}
