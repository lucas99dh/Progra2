package org.uade.structure.implementation.dynamic;

import org.uade.structure.definition.LinkedListADT;

public class DynamicLinkedListADT implements LinkedListADT {

    /** Nodo interno de la lista enlazada */
    private static final class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;   // primero
    private Node tail;   // último
    private int length;  // cantidad de elementos

    @Override
    public void add(int value) {
        Node n = new Node(value);
        if (head == null) {      // lista vacía
            head = tail = n;
        } else {
            tail.next = n;       // engancho al final
            tail = n;            // actualizo último
        }
        length++;
    }

    @Override
    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("index=" + index + " size=" + length);
        }

        if (index == length) {   // insertar al final ≡ add
            add(value);
            return;
        }

        Node n = new Node(value);

        if (index == 0) {        // insertar al principio
            n.next = head;
            head = n;
            if (length == 0) {   // si estaba vacía, tail también es n
                tail = n;
            }
            length++;
            return;
        }

        // insertar en posición intermedia: busco el anterior
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        n.next = prev.next;
        prev.next = n;

        if (n.next == null) {    // si quedó al final, actualizo tail
            tail = n;
        }
        length++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index=" + index + " size=" + length);
        }

        if (index == 0) {                 // borrar el primero
            head = head.next;             // salteo el viejo head
            if (length == 1) {            // si era el único, tail también debe quedar null
                tail = null;
            }
            length--;
            return;
        }

        // buscar el anterior al nodo a borrar
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        // 'prev.next' es el que vamos a borrar
        Node borrar = prev.next;
        prev.next = borrar.next;          // salteo el nodo borrado

        if (prev.next == null) {          // si borramos el último, tail cambia
            tail = prev;
        }

        length--;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index=" + index + " size=" + length);
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value);
            cur = cur.next;
            if (cur != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
