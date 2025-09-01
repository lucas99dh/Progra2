package org.uade.algorithm.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.DynamicStackADT;
import org.uade.structure.util.StackADTUtil;
//Cree e inicialice la pila DADA. Pase el primer elemento de la pila DADA a su última
//posición, dejando los restantes elementos en el orden original.

public class AdditionalExercise13 {
    public static void main(String[] args) {
        StackADT dada = new DynamicStackADT();

        dada.add(1);
        dada.add(2);
        dada.add(3);
        dada.add(4);

        System.out.println("dada original:");
        StackADTUtil.print(dada);

        invertFirstElement(dada);
        System.out.println("dada invertida el primer elemento:");
        StackADTUtil.print(dada);


    }

    public static void invertFirstElement(StackADT dada){
        if (dada.isEmpty()) {
            System.out.println("La pila DADA está vacía.");
            return;
        }

        StackADT dadaCopy = StackADTUtil.copy(dada);

        int size = 0;
        int counter = 0;
        int element = 0;

        while (!dada.isEmpty()){
            size++;
            dada.remove();
        }

        StackADT aux = StackADTUtil.copy(dada);

        while (!dadaCopy.isEmpty()){
            counter++;
            if(size == counter){
                element = dadaCopy.getElement();
                dadaCopy.remove();
            }
            else{
                aux.add(dadaCopy.getElement());
                dadaCopy.remove();
            }
        }

        //StackADT aux2 = StackADTUtil.copy(dada);

        while (!aux.isEmpty()){
            dada.add(aux.getElement());
            aux.remove();
        }
        dada.add(element);
    }
}
