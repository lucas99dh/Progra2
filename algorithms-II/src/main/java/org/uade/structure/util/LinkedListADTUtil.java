package org.uade.structure.util;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;
import org.w3c.dom.Node;

public class LinkedListADTUtil {

    public static LinkedListADT createLinkedListADT(LinkedListADT list) {
        LinkedListADT result = null;
        if (list instanceof DynamicLinkedListADT){
            result = new DynamicLinkedListADT();
        } else {
            result = new StaticLinkedListADT();
        }
        return result;
    }

    public static void print(LinkedListADT list) {
        for(int i=0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

