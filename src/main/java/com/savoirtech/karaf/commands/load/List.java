package com.savoirtech.karaf.commands.load;

import com.savoirtech.karaf.load.LoadService;

import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.console.AbstractAction;

@Command(scope = "load", name = "list", description = "List running threads")
public class List extends AbstractAction {
    private LoadService loadService;

    @Override
    protected Object doExecute() throws Exception {

        java.util.List<Thread> threads = loadService.getThreads();
        for (int i = 0; i < threads.size(); i++) {
            System.out.println(i + "    " + threads.get(i).getId());
        }

        return null;
    }

    public void setLoadService(LoadService loadService) {
        this.loadService = loadService;
    }
}
