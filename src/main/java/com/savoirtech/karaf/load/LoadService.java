package com.savoirtech.karaf.load;

import java.util.List;

public interface LoadService {

    List<Thread> getThreads();

    Thread getThread(int threadIndex);

    void startHeavyCPUThreads(int numberOfThreads);

    void stopAllThreads();

    void stopThread(int threadIndex);
}
