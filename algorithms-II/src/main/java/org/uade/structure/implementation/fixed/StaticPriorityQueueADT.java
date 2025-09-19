package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.PriorityQueueADT;

import java.util.NoSuchElementException;

public class StaticPriorityQueueADT implements PriorityQueueADT {
    private final int[] values;
    private final int[] prios;
    private int count;

    public StaticPriorityQueueADT() { this(10); }
    public StaticPriorityQueueADT(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacidad > 0");
        this.values = new int[capacity];
        this.prios  = new int[capacity];
        this.count  = 0;
    }

    @Override
    public int getElement() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        return values[0];
    }

    @Override
    public int getPriority() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        return prios[0];
    }

    @Override
    public void add(int value, int priority) {
        if (count == values.length) {
            throw new IllegalStateException("Cola llena (capacidad=" + values.length + ")");
        }

        int pos = count - 1;
        while (pos >= 0 && prios[pos] > priority) {
            prios[pos + 1]  = prios[pos];
            values[pos + 1] = values[pos];
            pos--;
        }
        prios[pos + 1]  = priority;
        values[pos + 1] = value;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        for (int i = 0; i < count - 1; i++) {
            prios[i]  = prios[i + 1];
            values[i] = values[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
