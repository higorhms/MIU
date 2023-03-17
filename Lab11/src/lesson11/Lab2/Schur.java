package lesson11.Lab2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schur {

    static boolean checkForSum(List<Integer> list, Integer z){
        if(list == null || z == null) return false;
        HashMap<Integer, Integer> aux = new HashMap<Integer, Integer>();

        for(Integer value : list){
            int auxValue = z - value;

            if(aux.containsKey(auxValue)) return true;

            aux.put(value, auxValue);
        }

        return false;
    }

    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        List list2 = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list2.add(1);
        list2.add(7);
        list2.add(3);

        System.out.println(Schur.checkForSum(list, 6));;
        System.out.println(Schur.checkForSum(list2, 6));;
    }
}
