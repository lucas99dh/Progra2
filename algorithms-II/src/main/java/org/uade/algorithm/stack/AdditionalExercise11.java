package org.uade.algorithm.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.DynamicStackADT;
import org.uade.structure.util.StackADTUtil;

public class AdditionalExercise11 {
    public static void main(String[] args) {
        StackADT mod = new DynamicStackADT();
        StackADT dada = new DynamicStackADT();

        mod.add(1);
        mod.add(2);
        mod.add(3);
        mod.add(4);


        dada.add(1);
        dada.add(3);
        dada.add(6);
        dada.add(8);
        dada.add(2);
        dada.add(4);
        dada.add(11);

        StackADT dadaCopy = StackADTUtil.copy(dada);
        StackADT result = new DynamicStackADT();
        boolean equals = true;

        while (!dadaCopy.isEmpty()){
            StackADT modCopy = StackADTUtil.copy(mod);
            while(!modCopy.isEmpty()){
                if(dadaCopy.getElement() == modCopy.getElement()){
                    equals = true;
                    break;
                } else {
                    equals = false;
                    modCopy.remove();
                }
            }
            if(!equals){
                result.add(dadaCopy.getElement());
            }
            dadaCopy.remove();
        }
        System.out.println("result = " + result);
    }
}
