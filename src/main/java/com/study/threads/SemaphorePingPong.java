package com.study.threads;

import java.util.concurrent.Semaphore;

public class SemaphorePingPong implements Runnable{

    private String msg;
    private static String turn;
    private static Semaphore semaphore = new Semaphore(1);

    public SemaphorePingPong(String msg) {
        this.msg = msg;
    }

    public void run() {
        while (true) {
            playTurn(msg);
        }
    }

    private void playTurn(String msg) {
        try {
            semaphore.acquire();
            if (!msg.equals(turn)) {
                turn = msg;
                System.out.print(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }

}
