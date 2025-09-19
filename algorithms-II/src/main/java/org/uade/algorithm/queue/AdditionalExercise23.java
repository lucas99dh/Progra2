package org.uade.algorithm.queue;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.DynamicQueueADT;
import org.uade.structure.implementation.dynamic.DynamicStackADT;
import org.uade.structure.util.QueueADTUtil;

public class AdditionalExercise23 {
    public static void main(String[] args) {
        DynamicQueueADT queue = new DynamicQueueADT();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        System.out.println(isPalindromo(queue));

    }

    public static boolean isPalindromo(QueueADT queue){
        QueueADT aux = QueueADTUtil.getNewQueue(queue);
        DynamicStackADT stack = new DynamicStackADT();
        QueueADT copy = QueueADTUtil.copy(queue);

        while (!copy.isEmpty()){
            stack.add(copy.getElement());
            copy.remove();
        }

        copy = QueueADTUtil.copy(queue);
        boolean palindromo = true;

        while(!stack.isEmpty()){
            while(!copy.isEmpty()){
                if(stack.getElement() != copy.getElement()){
                    palindromo = false;
                    break;
                }
                copy.remove();
                break;
            }
            if(palindromo){
                stack.remove();
            } else {
                break;
            }
        }
        return palindromo;
    }
}
