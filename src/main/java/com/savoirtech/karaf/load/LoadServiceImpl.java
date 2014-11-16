package com.savoirtech.karaf.load;

import com.savoirtech.karaf.load.thread.HeavyCPUThread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoadServiceImpl implements LoadService {
    private List<Thread> threads;

    public LoadServiceImpl() {
        threads = new ArrayList<>();
    }

    @Override
    public List<Thread> getThreads() {
        return threads;
    }

    @Override
    public Thread getThread(int threadIndex) {
        return threads.get(threadIndex);
    }

    @Override
    public void startHeavyCPUThreads(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new HeavyCPUThread();
            thread.start();
            threads.add(thread);
        }
    }

    @Override
    public void stopAllThreads() {
        Iterator<Thread> threadIterator = threads.iterator();
        while (threadIterator.hasNext()) {
            _stopThread(threadIterator.next());
            threadIterator.remove();
        }
    }

    @Override
    public void stopThread(int threadIndex) {
        Thread thread = threads.get(threadIndex);
        _stopThread(thread);
        threads.remove(threadIndex);
    }

    private void _stopThread(Thread thread) {
        thread.interrupt();
        try {
            thread.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
