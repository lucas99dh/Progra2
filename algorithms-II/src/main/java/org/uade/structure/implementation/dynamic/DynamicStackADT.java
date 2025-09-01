package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.StackADT;

import java.util.NoSuchElementException;

public class DynamicStackADT implements StackADT {

    private static final class Node {
        int value;
        Node next;
        Node(int v, Node n) { value = v; next = n; }
    }

    private Node top;
    private int size;

    @Override
    public int getElement() {
        if (isEmpty()) throw new NoSuchElementException("Pila vacía");
        return top.value;
    }

    @Override
    public void add(int value) {
        top = new Node(value, top);
        size++;
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new NoSuchElementException("Pila vacía");
        top = top.next;
        size--;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node n = top; n != null; n = n.next) {
            sb.append(n.value);
            if (n.next != null) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}