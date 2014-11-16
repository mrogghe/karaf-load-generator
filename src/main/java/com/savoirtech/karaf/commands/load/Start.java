package com.savoirtech.karaf.commands.load;

import com.savoirtech.karaf.load.LoadService;

import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;
import org.apache.karaf.shell.console.AbstractAction;

@Command(scope = "load", name = "start", description = "Start N number of heavy CPU threads")
public class Start extends AbstractAction {
    private LoadService loadService;

    @Option(name = "-t", aliases = { "--threads" }, description = "Number of threads to add", required = true, multiValued = false)
    private int numThreads;

    @Override
    protected Object doExecute() throws Exception {
        loadService.startHeavyCPUThreads(numThreads);

        return null;
    }

    public void setLoadService(LoadService loadService) {
        this.loadService = loadService;
    }
}
