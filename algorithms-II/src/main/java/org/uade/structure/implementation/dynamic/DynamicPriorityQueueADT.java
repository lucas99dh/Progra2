package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.PriorityQueueADT;

import java.util.NoSuchElementException;

public class DynamicPriorityQueueADT implements PriorityQueueADT {
    private static final class Node {
        int value;
        int priority;
        Node next;
        Node(int v, int p) { value = v; priority = p; }
    }

    private Node head; // frente: elemento con prioridad más alta (número más chico)

    @Override
    public int getElement() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        return head.value;
    }

    @Override
    public int getPriority() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        return head.priority;
    }

    @Override
    public void add(int value, int priority) {
        Node n = new Node(value, priority);
        if (head == null) {
            head = n;
            return;
        }

        // Convención: menor número = mayor prioridad.
        if (priority < head.priority) {
            n.next = head;
            head = n;
            return;
        }

        Node prev = head;
        Node cur = head.next;

        while (cur != null && cur.priority <= priority) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = n;
        n.next = cur;
    }

    @Override
    public void remove() {
        if (isEmpty()) throw new NoSuchElementException("Cola vacía");
        head = head.next;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
