package prog23round;

public class Prog3 {

    public static void main(String[] args) {
        float firstValue = 1.27F;
        float secondValue = 3.881F;
        float thirdValue = 9.6F;


        float sumOfTheFloats = firstValue + secondValue + thirdValue;
        int sumOfTheFloatsAsInt = (int) sumOfTheFloats;
        int sumOfTheFloatsAsIntUsingMathRound = Math.round(sumOfTheFloats);

        System.out.println("Sum of the floats: " + sumOfTheFloats);
        System.out.println("Sum of the floats as int: " + sumOfTheFloatsAsInt);
        System.out.println("Sum of the floats as int using Math.round: " + sumOfTheFloatsAsIntUsingMathRound);

        /**
         * Sum of the floats: 14.751
         * Sum of the floats as int: 14
         * Sum of the floats as int using Math.round: 15
         */
    }

}
