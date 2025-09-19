package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.SetADT;

import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class StaticSetADT implements SetADT {
    private final int[] data;
    private int count;

    public StaticSetADT() { this(10); }
    public StaticSetADT(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacidad > 0");
        this.data = new int[capacity];
        this.count = 0;
    }

    @Override
    public boolean exist(int value) {
        for (int i = 0; i < count; i++) {
            if (data[i] == value) return true;
        }
        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) throw new NoSuchElementException("Conjunto vacío");
        int i = ThreadLocalRandom.current().nextInt(count);
        return data[i];
    }

    @Override
    public void add(int value) {
        if (exist(value)) return;
        if (count == data.length) {
            throw new IllegalStateException("Conjunto lleno (capacidad=" + data.length + ")");
        }
        data[count++] = value;
    }

    @Override
    public void remove(int element) {
        int idx = -1;
        for (int i = 0; i < count; i++) {
            if (data[i] == element) { idx = i; break; }
        }
        if (idx == -1) return;
        data[idx] = data[count - 1];
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
