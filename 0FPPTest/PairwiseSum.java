import java.util.Arrays;

public class PairwiseSum {
        public static void main(String[] args) {
            int[] input = new int[]{2, 1, 18, -5};
            System.out.println("Input: {2, 1, 18, -5} | Expected Output: ({3, 13}) | Output: " + Arrays.toString(execute(input)));

            int[] input2 = new int[]{2, 1, 18, -5, -5, -15, 0, 0, 1, -1};
            System.out.println("Input: {2, 1, 18, -5, -5, -15, 0, 0, 1, -1} | Expected Output: ({3, 13, -20, 0, 0}) | Output: " + Arrays.toString(execute(input2)));

            int[] input3 = new int[]{2, 1, 18};
            System.out.println("Input: {2, 1, 18} | Expected Output: (null) | Output: " + execute(input3));

            int[] input4 = new int[]{};
            System.out.println("Input: {} | Expected Output: (null) | Output: " + execute(input4));
        }

        static int[] execute(int[ ] a)  {
            if(a.length == 0) return null;
            if(a.length % 2 != 0) return null;

            int[] auxArray = new int[a.length/2];
            int auxArrayIndex = 0;

            for(int index = 0; index < a.length; index += 2){
                auxArray[auxArrayIndex] = a[index] + a[index + 1];
                auxArrayIndex++;
            }

            return auxArray;
        }




    }