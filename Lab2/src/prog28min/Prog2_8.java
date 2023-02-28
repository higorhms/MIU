package prog28min;

public class Prog2_8 {

    static int min(int[] arrayOfInts){
        if(arrayOfInts.length == 0) return 0;

        int minValue = Integer.MAX_VALUE;

        for(int number : arrayOfInts){
            if(number < minValue) minValue = number;
        }

        return minValue;
    }
}
