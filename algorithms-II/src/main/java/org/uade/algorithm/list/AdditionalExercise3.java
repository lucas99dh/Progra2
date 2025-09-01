package org.uade.algorithm.list;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;

import static org.uade.structure.util.LinkedListADTUtil.createLinkedListADT;
import static org.uade.structure.util.LinkedListADTUtil.print;

public class AdditionalExercise3 {
    public static void main(String[] args) {
        LinkedListADT list1 = new DynamicLinkedListADT();
        LinkedListADT list2 = new DynamicLinkedListADT();

        list1.add(1);
        list1.add(2);
        list1.add(5);

        list2.add(3);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        LinkedListADT result = mergeList(list1, list2);

        print(result);
    }

    private static LinkedListADT mergeList(LinkedListADT list1, LinkedListADT list2){
        LinkedListADT result = createLinkedListADT(list1);

        int countList1 = 0;
        int countList2 = 0;


        while (countList1 < list1.size() && countList2 < list2.size()) {
            if(list1.get(countList1) > list2.get(countList2)) {
                result.add(list2.get(countList2));
                countList2++;
            } else{
                result.add(list1.get(countList1));
                countList1++;
            }
        }

        if(countList1 != list1.size()){
            for(int i = countList1; i < list1.size(); i++){
                result.add(list1.get(i));
            }
        }
        if(countList2 != list2.size()){
            for(int i = countList2; i < list2.size(); i++){
                result.add(list2.get(i));
            }
        }
        return result;
    }
}