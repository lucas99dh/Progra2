package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.QueueADT;

import java.util.NoSuchElementException;

public class DynamicQueueADT implements QueueADT {

    private static final class Node {
        int value;
        Node next;
        Node(int v) { value = v; }
    }

    private Node head; // (primer elemento)
    private Node tail; // (último elemento)

    @Override
    public int getElement() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        return head.value;
    }

    @Override
    public void add(int value) {
        Node n = new Node(value);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
