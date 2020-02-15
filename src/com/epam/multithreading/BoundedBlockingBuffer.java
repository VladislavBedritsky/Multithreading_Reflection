package com.epam.multithreading;

import java.util.concurrent.Exchanger;

import static java.lang.Thread.sleep;

public class BoundedBlockingBuffer {

    private Object data;
    private Exchanger<Object> exchanger;

    public BoundedBlockingBuffer(Exchanger<Object> exchanger) {
        this.exchanger = exchanger;
    }

    public void take() {
        new Thread(() -> {
            try {
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void put(Object data) {
        this.data = data;
        new Thread(() -> {
            try {
                exchanger.exchange(data);
                sleep(1000);
                exchanger.exchange("something else");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public String toString() {
        return "BoundedBlockingBuffer{" +
                "data=" + data +
                '}';
    }
}
