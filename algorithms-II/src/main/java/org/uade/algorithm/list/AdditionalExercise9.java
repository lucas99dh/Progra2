package org.uade.algorithm.list;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;

public class AdditionalExercise9 {
    public static void main(String[] args) {
        LinkedListADT list1 = new DynamicLinkedListADT();
        LinkedListADT list2 = new DynamicLinkedListADT();

        list1.add(1);
        list1.add(4);
        list1.add(3);
        list1.add(5);
        list1.add(1);

        list2.add(3);
        list2.add(4);
        list2.add(4);
        list2.add(1);
        list2.add(5);
        list2.add(1);

        boolean result = checkList(list1, list2);

        if (result) {
            System.out.println("las listas son iguales");
        }
        else {
            System.out.println("las listas son distintas");
        }
    }

    public static boolean checkList(LinkedListADT list1, LinkedListADT list2) {
        boolean result = false;
        if(list1.size() >= list2.size()){
            for (int i = 0; i < list1.size(); i++) {
                result = false;
                for (int j = 0; j < list2.size(); j++) {
                    if(list1.get(i) == list2.get(j)) {
                        result = true;
                        break;
                    }
                }
                if (!result) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {
                result = false;
                for (int j = 0; j < list1.size(); j++) {
                    if(list2.get(i) == list1.get(j)) {
                        result = true;
                        break;
                    }
                }
                if (!result) {
                    break;
                }
            }
        }

        return result;
    }
}
