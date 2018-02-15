package com.belykh.lab2.command.impl;

import com.belykh.lab2.command.ActionCommand;
import com.belykh.lab2.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panda on 16.11.17.
 */
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return ConfigurationManager.getProperty("path.page.index");
    }
}
