package com.savoirtech.karaf.commands.load;

import com.savoirtech.karaf.load.LoadService;

import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.console.AbstractAction;

@Command(scope = "load", name = "stopAll", description = "Stop all threads")
public class StopAll extends AbstractAction {
    private LoadService loadService;

    @Override
    protected Object doExecute() throws Exception {

        loadService.stopAllThreads();

        return null;
    }

    public void setLoadService(LoadService loadService) {
        this.loadService = loadService;
    }
}