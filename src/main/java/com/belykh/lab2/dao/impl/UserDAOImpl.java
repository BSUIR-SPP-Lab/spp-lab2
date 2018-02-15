package com.belykh.lab2.dao.impl;

import com.belykh.lab2.dao.UserDAO;
import com.belykh.lab2.entity.UserDTO;
import com.belykh.lab2.exception.DAOException;
import com.belykh.lab2.pool.ConnectionPool;
import com.belykh.lab2.pool.exception.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 6.1.18.
 */
public class UserDAOImpl implements UserDAO {

    private static final String SQL_GET_USERS = "SELECT `test_user`.`id`, `test_user`.`first_name`, `test_user`.email,`test_user`.`login`,`test_user`.`last_name` FROM test_user";

    private static final String USER_ID = "id";
    private static final String USER_FIRST_NAME = "first_name";
    private static final String USER_EMAIL = "email";
    private static final String USER_LOGIN = "login";
    private static final String USER_LAST_NAME = "last_name";


    @Override
    public List<UserDTO> findAllUsers() throws DAOException {

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USERS)) {

            ResultSet resultSet = statement.executeQuery();
            return createUserList(resultSet);
        } catch (SQLException|ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    private List<UserDTO> createUserList(ResultSet resultSet) throws SQLException {
        List<UserDTO> resultList = new ArrayList<>();
        while(resultSet.next()){
            resultList.add(createUser(resultSet));
        }
        return resultList;
    }

    private UserDTO createUser(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(USER_ID);
        String firstName = resultSet.getString(USER_FIRST_NAME);
        String email = resultSet.getString(USER_EMAIL);
        String login = resultSet.getString(USER_LOGIN);
        String lastName = resultSet.getString(USER_LAST_NAME);
        return new UserDTO(id,login,email,firstName,lastName);
    }

}
