package com.belykh.lab2.command.impl;

import com.belykh.lab2.command.ActionCommand;
import com.belykh.lab2.entity.UserDTO;
import com.belykh.lab2.exception.CommandException;
import com.belykh.lab2.exception.ServiceException;
import com.belykh.lab2.manager.ConfigurationManager;
import com.belykh.lab2.service.ServiceFactory;
import com.belykh.lab2.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUsersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        UserService service = ServiceFactory.getInstance().getUserService();
        try {
            List<UserDTO> userList =  service.findAllUsers();
            if(!userList.isEmpty()){
                request.setAttribute("userList",userList);
                request.setAttribute("errorUserListIsEmpty",null);
            }else{
                request.setAttribute("userList",null);
                request.setAttribute("errorUserListIsEmpty","User list is empty");
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
            return ConfigurationManager.getProperty("path.page.main");

    }
}
