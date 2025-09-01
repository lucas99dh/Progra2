package org.uade.algorithm.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.DynamicStackADT;
import org.uade.structure.util.StackADTUtil;

// Cree, inicialice y la pila DADA. Elimine los elementos repetidos de la misma dejando
// solamente un ejemplar de cada valor.
public class AdditionalExercise16 {
    public static void main(String[] args) {
        StackADT dada = new DynamicStackADT();

        dada.add(1);
        dada.add(2);
        dada.add(1);
        dada.add(3);
        dada.add(4);
        dada.add(2);
        dada.add(5);
        dada.add(2);

        System.out.println("dada original" );
        StackADTUtil.print(dada);

        removeDuplicates(dada);

        System.out.println("dada sin duplicados" );
        StackADTUtil.print(dada);
    }
    private static void removeDuplicates(StackADT dada) {
        if(dada.isEmpty()){
            System.out.println("La pila esta vacia");
            return;
        }

        StackADT aux = StackADTUtil.getNewStack(dada);
        boolean duplicated = true;
        int element = 0;

        while (!dada.isEmpty()){
            element = dada.getElement();
            dada.remove();
            StackADT dadaCopy = StackADTUtil.copy(dada);
            if(dadaCopy.isEmpty()){
                dada.add(element);
                break;
            }
            while (!dadaCopy.isEmpty()){
                if (dadaCopy.getElement() != element){
                    duplicated = false;
                    dadaCopy.remove();
                } else{
                    duplicated = true;
                    break;
                }
            }
            if (!duplicated){
                aux.add(element);
            }
        }

        while (!aux.isEmpty()){
            dada.add(aux.getElement());
            aux.remove();
        }
    }
}
