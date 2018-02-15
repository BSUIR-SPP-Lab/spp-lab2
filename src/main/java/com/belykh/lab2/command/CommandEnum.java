package com.belykh.lab2.command;

import com.belykh.lab2.command.impl.ShowUsersCommand;

/**
 * Created by panda on 16.11.17.
 */
public enum CommandEnum {
    SHOW_USERS(new ShowUsersCommand());

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}

