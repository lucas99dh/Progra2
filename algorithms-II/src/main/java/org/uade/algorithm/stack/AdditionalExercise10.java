package org.uade.algorithm.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.DynamicStackADT;
import org.uade.structure.util.StackADTUtil;

public class AdditionalExercise10 {
    public static void main(String[] args) {
        StackADT pozo = new DynamicStackADT();
        StackADT jug1 = new DynamicStackADT();
        StackADT jug2 = new DynamicStackADT();
        int contador = 0;

        pozo.add(1);
        pozo.add(2);
        pozo.add(3);
        pozo.add(4);
        pozo.add(5);

        StackADT pozoCopy = StackADTUtil.copy(pozo);

        while (!pozoCopy.isEmpty()) {
            if(contador % 2 == 0 ){
                jug1.add(pozoCopy.getElement());
                pozoCopy.remove();
                contador++;
            } else  {
                jug2.add(pozoCopy.getElement());
                pozoCopy.remove();
                contador++;
            }
        }


        System.out.println("jug1 = " + jug1);
        StackADTUtil.print(jug1);
        System.out.println("jug2 = " + jug2);
        StackADTUtil.print(jug2);

    }
}
