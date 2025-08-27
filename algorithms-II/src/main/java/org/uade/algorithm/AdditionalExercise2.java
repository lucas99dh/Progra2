package org.uade.algorithm;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;
import org.uade.structure.implementation.fixed.StaticLinkedListADT;

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

        LinkedListADT result = desDuplicatedLista(list);

        print(result);
    }

    private static LinkedListADT desDuplicatedLista(LinkedListADT list){
        LinkedListADT result = createLinkedListADT(list);

        int value;

        for(int i=0; i < list.size(); i++){
            value = list.get(i);

            for(int j=0; j < result.size(); j++){
                if(result.get(j) == value){
                    result.remove(j);
                }
            }
        }

        return result;
    }
}
