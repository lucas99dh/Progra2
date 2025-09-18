package org.uade.structure.implementation.fixed;

import org.uade.structure.definition.PriorityQueueADT;

import java.util.NoSuchElementException;

public class StaticPriorityQueueADT implements PriorityQueueADT {
    private final int[] values;
    private final int[] prios;
    private int count;           // cuántos elementos hay

    public StaticPriorityQueueADT() { this(100); }  // capacidad por defecto
    public StaticPriorityQueueADT(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacidad > 0");
        this.values = new int[capacity];
        this.prios  = new int[capacity];
        this.count  = 0;
    }

    @Override
    public int getElement() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        return values[0]; // el frente es el índice 0 (mayor prioridad según convención)
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

        // Insertar manteniendo ORDEN ASCENDENTE por prioridad (menor número primero) y de forma ESTABLE
        int pos = count - 1;
        while (pos >= 0 && prios[pos] > priority) {
            prios[pos + 1]  = prios[pos];
            values[pos + 1] = values[pos];
            pos--;
        }
        prios[pos + 1]  = priority;
        values[pos + 1] = value;
        count++;

        // Si tu regla fuera "mayor número = mayor prioridad", cambia la condición a:
        // while (pos >= 0 && prios[pos] < priority) { ... }
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        // quitamos el frente (índice 0) y corremos a la izquierda
        for (int i = 0; i < count - 1; i++) {
            prios[i]  = prios[i + 1];
            values[i] = values[i + 1];
        }
        // opcional: limpiar último slot
        // prios[count - 1] = 0; values[count - 1] = 0;
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

}
