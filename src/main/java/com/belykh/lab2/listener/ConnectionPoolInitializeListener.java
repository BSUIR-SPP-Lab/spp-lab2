package com.belykh.lab2.listener;

import com.belykh.lab2.pool.ConnectionPool;
import com.belykh.lab2.pool.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by panda on 15.11.17.
 */
@WebListener
public class ConnectionPoolInitializeListener implements ServletContextListener {

    private static final int POOL_SIZE = 20;
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolInitializeListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.init(POOL_SIZE);
        } catch (ConnectionPoolException e) {
            LOGGER.log(Level.FATAL,e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().destroy();
        } catch (ConnectionPoolException e) {
            LOGGER.log(Level.FATAL,e);
            throw new RuntimeException(e);
        }
    }
}
