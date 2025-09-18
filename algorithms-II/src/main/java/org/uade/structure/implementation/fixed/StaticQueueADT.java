package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.QueueADT;

import java.util.NoSuchElementException;

public class StaticQueueADT implements QueueADT {
    private final int[] data;
    private int head;
    private int tail;
    private int count;

    public StaticQueueADT() {
        this(10);
    }

    public StaticQueueADT(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacidad > 0");
        this.data = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    @Override
    public int getElement() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        return data[head];
    }

    @Override
    public void add(int value) {
        if (count == data.length) {
            throw new IllegalStateException("Cola llena (capacidad=" + data.length + ")");
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        head = (head + 1) % data.length;
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
