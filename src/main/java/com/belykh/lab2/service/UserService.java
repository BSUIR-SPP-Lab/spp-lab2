package com.belykh.lab2.service;

import com.belykh.lab2.entity.UserDTO;
import com.belykh.lab2.exception.ServiceException;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers() throws ServiceException;
}
