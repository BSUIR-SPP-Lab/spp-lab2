package com.belykh.lab2.service.impl;

import com.belykh.lab2.dao.DAOFactory;
import com.belykh.lab2.dao.UserDAO;
import com.belykh.lab2.entity.UserDTO;
import com.belykh.lab2.exception.DAOException;
import com.belykh.lab2.exception.ServiceException;
import com.belykh.lab2.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<UserDTO> findAllUsers() throws ServiceException {
        UserDAO dao = DAOFactory.getInstance().getUserDAO();
        try {
            return dao.findAllUsers();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
