package com.belykh.lab2.service;

import com.belykh.lab2.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }
}
