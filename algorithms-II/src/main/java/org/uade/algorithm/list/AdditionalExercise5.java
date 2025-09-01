package org.uade.algorithm.list;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;

public class AdditionalExercise5 {
    public static void main(String[] args) {
        LinkedListADT list = new DynamicLinkedListADT();
        int value = 4;

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int result = searchValue(list, value);

        System.out.println("result = " + result);


    }

    public static int searchValue(LinkedListADT list, int value){
        int result = 0;
        int size = list.size();
        if(list.get(0) ==  value){
            result = list.get(1);
        } else if (list.get(size - 1) == value){
            result = list.get(size-1);
        } else {
            for(int i = 1; i < size-2; i++){
                if(list.get(i) == value){
                    result = list.get(i-1);
                    break;
                }
            }
        }
        return result;
    }
}
