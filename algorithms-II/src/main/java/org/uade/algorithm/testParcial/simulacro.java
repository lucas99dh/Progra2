package org.uade.algorithm.testParcial;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamic.DynamicSetADT;
import org.uade.structure.util.SetADTUtil;

public class simulacro {
    public static void main(String[] args) {
        DynamicSetADT set1 = new DynamicSetADT();
        DynamicSetADT set2 = new DynamicSetADT();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2.add(1);
        set2.add(8);
        set2.add(2);
        set2.add(0);

        SetADT set3 = innerSet(set1, set2);
        SetADTUtil.print(set3);

    }
    private static SetADT innerSet(SetADT set1, SetADT set2){
        SetADT copySet1 = SetADTUtil.copy(set1);
        SetADT result = SetADTUtil.getNewSet(set1);

        while(!copySet1.isEmpty()){
            int value1 = copySet1.choose();
            boolean equeals = false;
            SetADT copySet2 = SetADTUtil.copy(set2);

            while(!copySet2.isEmpty()){
                int value2 = copySet2.choose();
                if(value1 == value2){
                    equeals = true;
                    break;
                } else{
                    copySet2.remove(value2);
                }
            } if (equeals){
                if(value1 % 2 == 0){
                    result.add(value1);
                    copySet1.remove(value1);
                }else {
                    copySet1.remove(value1);
                }
            } else {
                copySet1.remove(value1);
            }
        }
        return result;
    }
}
