package org.uade.algorithm.queue;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.DynamicQueueADT;
import org.uade.structure.util.QueueADTUtil;

public class AdditionalExercise21 {
    public static void main(String[] args) {
        DynamicQueueADT queue = new DynamicQueueADT();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        QueueADTUtil.print(queue);

        firtToLast(queue);

        QueueADTUtil.print(queue);
    }

    private static void firtToLast(QueueADT queue){
        int first = queue.getElement();
        QueueADT aux = QueueADTUtil.getNewQueue(queue);

        while (!queue.isEmpty()){
            aux.add(queue.getElement());
            queue.remove();
        }
        aux.remove();
        while (!aux.isEmpty()){
            queue.add(aux.getElement());
            aux.remove();
        }
        queue.add(first);
    }
}
