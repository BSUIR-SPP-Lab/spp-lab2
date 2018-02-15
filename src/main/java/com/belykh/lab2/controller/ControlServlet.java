package com.belykh.lab2.controller;

import com.belykh.lab2.command.ActionCommand;
import com.belykh.lab2.command.CommandProvider;
import com.belykh.lab2.exception.CommandException;
import com.belykh.lab2.manager.ConfigurationManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by panda on 15.11.17.
 */
@WebServlet(name = "ControlServlet")
public class ControlServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(ControlServlet.class);
    @Override
    public void init() throws ServletException {
        logger.log(Level.DEBUG, "initialize servlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String page = null;
        CommandProvider provider = new CommandProvider();
        ActionCommand command = provider.getCommand(request);
        try {
            page = command.execute(request, response);
        } catch (CommandException e) {
            logger.log(Level.ERROR, e);
            throw new RuntimeException(e);
        }


        if (page != null) {
            if (request.getAttribute("redirect") != null) {
                logger.log(Level.DEBUG, "redirect = " + request.getAttribute("redirect"));
                response.sendRedirect(request.getAttribute("redirect").toString());
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
                requestDispatcher.forward(request, response);
            }
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
