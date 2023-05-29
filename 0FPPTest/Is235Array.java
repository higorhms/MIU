public class Is235Array {
        public static void main(String[] args) {
            int[] input = new int[]{2, 3, 5, 7, 11} ;
            System.out.println("Input: {2, 3, 5, 7, 11}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{2, 3, 6, 7, 11};
            System.out.println("Input: {2, 3, 6, 7, 11} | Expected Output: (0) | Output: " + execute(input2));

            int[] input3 = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
            System.out.println("Input: {2, 3, 4, 5, 6, 7, 8, 9, 10} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{2, 4, 8, 16, 32};
            System.out.println("Input: {2, 4, 8, 16, 32} | Expected Output: (1) | Output: " + execute(input4));

            int[] input5 = new int[]{3, 9, 27, 7, 1, 1, 1, 1, 1};
            System.out.println("Input: {3, 9, 27, 7, 1, 1, 1, 1, 1} | Expected Output: (1) | Output: " + execute(input5));

            int[] input6 = new int[]{7, 11, 77, 49};
            System.out.println("Input: {7, 11, 77, 49} | Expected Output: (1) | Output: " + execute(input6));

            int[] input7 = new int[]{2};
            System.out.println("Input: {2} | Expected Output: (1) | Output: " + execute(input7));

            int[] input8 = new int[]{};
            System.out.println("Input: {} | Expected Output: (1) | Output: " + execute(input8));

            int[] input9 = new int[]{7, 2, 7, 2, 7, 2, 7, 2, 3, 7, 7};
            System.out.println("Input: {7, 2, 7, 2, 7, 2, 7, 2, 3, 7, 7} | Expected Output: (1) | Output: " + execute(input9));
        }

        static int execute(int[ ] a)  {
            if(a.length == 0) return 1;

            int countDivisible = 0;

            for(int number : a){
                  if(number % 2 == 0) countDivisible++;
                  if(number % 3 == 0) countDivisible++;
                  if(number % 5 == 0) countDivisible++;
                  if(number % 2 != 0 && number % 3 != 0 && number % 5 != 0) countDivisible++;
            }

            if(countDivisible == a.length) return 1;

            return 0;
        }

    }