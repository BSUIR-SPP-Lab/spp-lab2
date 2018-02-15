package com.belykh.lab2.dao;

import com.belykh.lab2.entity.UserDTO;
import com.belykh.lab2.exception.DAOException;

import java.util.List;

public interface UserDAO {
    List<UserDTO> findAllUsers() throws DAOException;
}
