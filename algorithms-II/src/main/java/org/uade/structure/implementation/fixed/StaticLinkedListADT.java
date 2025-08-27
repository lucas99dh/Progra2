package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.LinkedListADT;

public class StaticLinkedListADT implements LinkedListADT {

    private final int[] data; // almacenamiento fijo
    private int length;       // cantidad usada

    private static final int DEFAULT_CAPACITY = 100;

    public StaticLinkedListADT() {
        this(DEFAULT_CAPACITY);
    }

    public StaticLinkedListADT(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        this.data = new int[capacity];
        this.length = 0;
    }

    @Override
    public void add(int value) {
        ensureSpaceForInsert();
        data[length] = value; // agrega al final
        length++;
    }

    @Override
    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("index=" + index + " size=" + length);
        }
        ensureSpaceForInsert();

        // corrimiento a la derecha: desde el último ocupado hasta 'index'
        for (int i = length - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        length++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index=" + index + " size=" + length);
        }

        // corrimiento a la izquierda: pisa desde index con el de la derecha
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }

        data[length - 1] = 0;

        length--;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index=" + index + " size=" + length);
        }
        return data[index];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    private void ensureSpaceForInsert() {
        if (length == data.length) {
            throw new IllegalStateException("Lista estática llena (capacidad=" + data.length + ")");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(data[i]);
            if (i < length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
