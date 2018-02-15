package com.belykh.lab2.dao;

import com.belykh.lab2.dao.impl.UserDAOImpl;

public class DAOFactory {

    private static DAOFactory instance = new DAOFactory();
    private final UserDAO userDAO = new UserDAOImpl();
    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
