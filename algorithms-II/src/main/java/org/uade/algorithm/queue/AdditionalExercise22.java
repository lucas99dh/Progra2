package org.uade.algorithm.queue;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.DynamicQueueADT;
import org.uade.structure.util.QueueADTUtil;

public class AdditionalExercise22 {
    public static void main(String[] args) {
        DynamicQueueADT queue1 = new DynamicQueueADT();
        DynamicQueueADT queue2 = new DynamicQueueADT();

        queue1.add(1);
        queue1.add(3);
        queue1.add(5);


        queue2.add(2);
        queue2.add(4);
        queue2.add(6);
        queue2.add(7);
        queue2.add(8);


        QueueADT mergedQueue = mergeQueue(queue1,queue2);
        QueueADTUtil.print(mergedQueue);


    }
    private static QueueADT mergeQueue(QueueADT queue1, QueueADT queue2) {
        QueueADT aux = QueueADTUtil.getNewQueue(queue1);
        QueueADT copy = QueueADTUtil.copy(queue1);
        QueueADT copy2 = QueueADTUtil.copy(queue2);
        while(!copy.isEmpty()){
            aux.add(copy.getElement());
            if(!copy2.isEmpty()){
                aux.add(copy2.getElement());
                copy2.remove();
            }
            copy.remove();
        }
        if(!copy2.isEmpty()){
            while(!copy2.isEmpty()){
                aux.add(copy2.getElement());
                copy2.remove();
            }
        }
        return aux;
    }
}
