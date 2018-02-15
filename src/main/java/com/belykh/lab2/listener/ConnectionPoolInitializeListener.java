package com.belykh.lab2.listener;

import com.belykh.lab2.pool.ConnectionPool;
import com.belykh.lab2.pool.exception.ConnectionPoolException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by panda on 15.11.17.
 */
@WebListener
public class ConnectionPoolInitializeListener implements ServletContextListener {

    private static final int POOL_SIZE = 1;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.init(POOL_SIZE);
        } catch (ConnectionPoolException e) {
            //todo add log
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().destroy();
        } catch (ConnectionPoolException e) {
            //todo Add log
        }
    }
}
