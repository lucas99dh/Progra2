package org.uade.algorithm.list;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;

import static org.uade.structure.util.LinkedListADTUtil.createLinkedListADT;
import static org.uade.structure.util.LinkedListADTUtil.print;

public class AdditionalExercise1 {
    public static void main(String[] args) {
        LinkedListADT list = new DynamicLinkedListADT();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        LinkedListADT result = invertirList(list);

        print(result);
    }

    private static LinkedListADT invertirList(LinkedListADT list){
        LinkedListADT result = createLinkedListADT(list);

        for(int i=0; i < list.size(); i++){
            result.insert(0, list.get(i));
        }

        return result;
    }
}
