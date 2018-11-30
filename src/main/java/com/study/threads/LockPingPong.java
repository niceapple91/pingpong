package com.study.threads;

import java.util.concurrent.locks.ReentrantLock;

public class LockPingPong implements Runnable {

    private String msg;
    private static String turn;
    private static ReentrantLock lock = new ReentrantLock();

    public LockPingPong(String msg) {
        this.msg = msg;
    }

    public void run() {
        while (true) {
            playTurn(msg);
        }
    }

    private void playTurn(String msg) {
        try {
            lock.lock();
            if (!msg.equals(turn)) {
                turn = msg;
                System.out.print(msg);
            }
        }
        finally {
            lock.unlock();
        }
    }

}
