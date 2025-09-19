package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.SetADT;

import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class DynamicSetADT implements SetADT {
    private static final class Node {
        int value;
        Node next;
        Node(int v, Node n) { value = v; next = n; }
    }

    private Node head;
    private int size;

    @Override
    public boolean exist(int value) {
        for (Node n = head; n != null; n = n.next) {
            if (n.value == value) return true;
        }
        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) throw new NoSuchElementException("Conjunto vacío");
        int k = ThreadLocalRandom.current().nextInt(size);
        Node n = head;
        for (int i = 0; i < k; i++) n = n.next;
        return n.value;
    }

    @Override
    public void add(int value) {
        if (exist(value)) return;
        head = new Node(value, head);
        size++;
    }

    @Override
    public void remove(int element) {
        Node prev = null, cur = head;
        while (cur != null && cur.value != element) {
            prev = cur; cur = cur.next;
        }
        if (cur == null) return;
        if (prev == null) head = cur.next;
        else prev.next = cur.next;
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
