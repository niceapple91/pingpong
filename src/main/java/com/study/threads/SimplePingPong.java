package com.study.threads;

public class SimplePingPong implements Runnable {

    private String msg;
    private static String turn;

    public SimplePingPong(String msg) {
        this.msg = msg;
    }

    public void run() {
        while (true) {
            playTurn(msg);
        }
    }

    private void playTurn(String msg) {
        synchronized (SimplePingPong.class) {
            if (!msg.equals(turn)) {
                turn = msg;
                System.out.print(msg);
            }
        }
    }

}
