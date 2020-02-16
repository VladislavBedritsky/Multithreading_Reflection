package com.epam.multithreading;

import java.util.concurrent.Exchanger;

import static java.lang.Thread.sleep;

public class BoundedBlockingBuffer {

    private Object data;
    private Exchanger<Object> exchanger;

    public BoundedBlockingBuffer(Exchanger<Object> exchanger) {
        this.exchanger = exchanger;
    }

    public synchronized void take() {
        new Thread(() -> {
            try {
                Object object = exchanger.exchange(null);
                System.out.println(object);
                object = exchanger.exchange(null);
                System.out.println(object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public synchronized void put(Object object) {
        new Thread(() -> {
            try {
                exchanger.exchange(object);
                exchanger.exchange("something else");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
