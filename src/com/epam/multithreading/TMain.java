package com.epam.multithreading;

import java.util.concurrent.Exchanger;

public class TMain {
    public static void main(String[] args) {
        Exchanger<Object> exchanger = new Exchanger<>();
        BoundedBlockingBuffer boundedBlockingBuffer = new BoundedBlockingBuffer(exchanger);
        boundedBlockingBuffer.put("Thread");
        boundedBlockingBuffer.take();

    }
}
