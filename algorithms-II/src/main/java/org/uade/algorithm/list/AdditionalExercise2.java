package org.uade.algorithm.list;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;

import static org.uade.structure.util.LinkedListADTUtil.createLinkedListADT;
import static org.uade.structure.util.LinkedListADTUtil.print;

public class AdditionalExercise2 {
    public static void main(String[] args) {
        LinkedListADT list = new DynamicLinkedListADT();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(2);

        LinkedListADT result = dropDuplicatedList(list);

        print(result);
    }

    private static LinkedListADT dropDuplicatedList(LinkedListADT list){
        LinkedListADT result = createLinkedListADT(list);

        result.add(list.get(0));

        boolean duplicated = false;

        for(int i=1; i < list.size(); i++){
                for (int j = 0; j < result.size(); j++){
                   if(list.get(i) == result.get(j)) {
                       duplicated = true;
                   }
                } if (!duplicated) {
                    result.add(list.get(i));
                }
                duplicated = false;
        }
        return result;
    }
}