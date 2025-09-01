package org.uade.structure.implementation.fixed;


import org.uade.structure.definition.StackADT;

import java.util.NoSuchElementException;

public class StaticStackADT implements StackADT {

    private final int[] data;
    private int top; // índice del tope. -1 si está vacía.

    public StaticStackADT() {
        this(5);
    }

    public StaticStackADT(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacidad > 0");
        this.data = new int[capacity];
        this.top = -1;
    }

    @Override
    public int getElement() {
        if (isEmpty()) throw new NoSuchElementException("Pila vacía");
        return data[top];
    }

    @Override
    public void add(int value) {
        if (top + 1 == data.length) {
            throw new IllegalStateException("Pila llena (capacidad=" + data.length + ")");
        }
        data[++top] = value;
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new NoSuchElementException("Pila vacía");
        top--;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = top; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
