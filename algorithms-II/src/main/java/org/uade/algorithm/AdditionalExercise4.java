package org.uade.algorithm;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamic.DynamicLinkedListADT;

import static org.uade.structure.util.LinkedListADTUtil.createLinkedListADT;
import static org.uade.structure.util.LinkedListADTUtil.print;

public class AdditionalExercise4 {
    public static void main(String[] args) {
        LinkedListADT list1 = new DynamicLinkedListADT();
        LinkedListADT list2 = new DynamicLinkedListADT();



        list1.add(1);
        list1.add(2);
        list1.add(5);
        list1.add(4);

        list2.add(3);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);

        LinkedListADT result = combineLists(list1, list2);

        print(result);


    }

    private static LinkedListADT combineLists(LinkedListADT list1, LinkedListADT list2) {
        LinkedListADT result = createLinkedListADT(list1);

        int contador1 = 0;
        int contador2 = 0;

        while(contador1 < list1.size() && contador2 < list2.size() ){
            result.add(list1.get(contador1));
            result.add(list2.get(contador2));
            contador1++;
            contador2++;
        }

        if(contador1 != list1.size()){
            for (int i = contador1; i < list1.size(); i++){
                result.add(list1.get(i));
            }
        }
        if(contador2 != list2.size()){
            for (int i = contador2; i < list2.size(); i++){
                result.add(list2.get(i));
            }
        }
        return  result;
    }
}
/*
1- crear las 2 listas
2- creo contadores para las 2 listas
3- mientras los 2 contadores sean < que el size de las 2 listas, inserto 1 y una
4- luego inserto lo restante de las otras listas
*/
