import java.util.Arrays;

public class IsCenteredArray {

        public static void main(String[] args) {
            int[] input = new int[]{5, 3, 3, 4, 5};
            System.out.println("Input: {5, 3, 3, 4, 5} | Expected Output: (false) | Output: " + isCentered(input));

            int[] input2 = new int[]{3, 2, 1, 4, 5};
            System.out.println("Input: {3, 2, 1, 4, 5} | Expected Output: (true) | Output: " + isCentered(input2));

            int[] input3 = new int[]{3, 2, 1, 4, 1};
            System.out.println("Input: {3, 2, 1, 4, 1} | Expected Output: (false) | Output: " + isCentered(input3));

            int[] input4 = new int[]{3, 2, 1, 1, 4, 6} ;
            System.out.println("Input: {3, 2, 1, 1, 4, 6}  | Expected Output: (false) | Output: " + isCentered(input4));

            int[] input5 = new int[]{1} ;
            System.out.println("Input: {1}  | Expected Output: (true) | Output: " + isCentered(input5));

        }

        static int isCentered(int[ ] a)  {
            if(a.length % 2 == 0) return 0;
            if(a.length == 1) return 1;

            int middleIndex = a.length / 2;

            for(int index = 0; index < a.length; index++){
                if(index != middleIndex){
                    if(a[index] <= a[middleIndex]) return 0;
                }
            }

            return 1;
        }


    }