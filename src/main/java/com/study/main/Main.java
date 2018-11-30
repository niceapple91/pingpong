package com.study.main;

import com.study.threads.LockPingPong;
import com.study.threads.SemaphorePingPong;
import com.study.threads.SimplePingPong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
//        executor.execute(new SimplePingPong("Ping "));
//        executor.execute(new SimplePingPong("Pong "));
//        executor.execute(new SemaphorePingPong("Ping "));
//        executor.execute(new SemaphorePingPong("Pong "));
        executor.execute(new LockPingPong("Ping "));
        executor.execute(new LockPingPong("Pong "));
    }

}
