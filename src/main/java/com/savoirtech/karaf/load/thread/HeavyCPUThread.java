package com.savoirtech.karaf.load.thread;

import java.util.Random;

public class HeavyCPUThread extends Thread {

    @Override
    public void run() {
        long x = -Long.MAX_VALUE;
        Random random = new Random();
        while (!this.isInterrupted()) {
            x += random.nextInt();
        }
    }
}
