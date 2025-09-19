package org.uade.structure.util;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamic.DynamicQueueADT;
import org.uade.structure.implementation.fixed.StaticQueueADT;

public class QueueADTUtil {
    public static void print(QueueADT queue) {
        QueueADT copy = copy(queue);
        while (!copy.isEmpty()) {
            System.out.println(copy.getElement());
            copy.remove();
        }
    }

    public static QueueADT copy(QueueADT queue) {
        QueueADT aux = getNewQueue(queue);
        QueueADT aux2 = getNewQueue(queue);

        while (!queue.isEmpty()) {
            aux.add(queue.getElement());
            aux2.add(queue.getElement());
            queue.remove();
        }

        while (!aux.isEmpty()) {
            queue.add(aux.getElement());
            aux.remove();
        }

        return aux2;
    }

    public static QueueADT getNewQueue(QueueADT queue) {
        if (queue instanceof StaticQueueADT) {
            return new StaticQueueADT();
        } else {
            return new DynamicQueueADT();
        }
    }
}
