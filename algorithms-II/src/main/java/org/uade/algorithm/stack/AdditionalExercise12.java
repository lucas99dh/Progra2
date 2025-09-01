package org.uade.algorithm.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamic.DynamicStackADT;
import org.uade.structure.util.StackADTUtil;

public class AdditionalExercise12 {
    public static void main(String[] args) {
/*  
 Cree e inicialice las pilas DADA, VALOR, PAR, IMPAR. Cargue la pila VALOR con al
menos un valor. Determine si la cantidad de elementos de la pila DADA es par. Si es
par, pase el elemento del tope de la pila VALOR a la pila PAR y sino páselo a la pila
IMPAR.
*/
        StackADT dada = new DynamicStackADT();
        StackADT valor = new DynamicStackADT();
        StackADT par = new DynamicStackADT();
        StackADT impar = new DynamicStackADT();

        valor.add(1);
        valor.add(2);
        valor.add(3);

        dada.add(1);
        dada.add(2);
        dada.add(3);
        dada.add(4);

        int contador = 0;

        StackADT dadaCopy = StackADTUtil.copy(dada);

        while (!dadaCopy.isEmpty()) {
            contador++;
            dadaCopy.remove();
        }

        if  (contador % 2 == 0) {
            par.add(valor.getElement());
            System.out.println("Pila Par:");
            StackADTUtil.print(par);
        }else {
            impar.add(valor.getElement());
            System.out.println("Pila impar:");
            StackADTUtil.print(impar);
        }
    }
}
