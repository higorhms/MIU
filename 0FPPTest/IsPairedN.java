public class IsPairedN {
        public static void main(String[] args) {
            int[] input = new int[]{1, 4, 1, 4, 5, 6};
            System.out.println("Input: {1, 4, 1, 4, 5, 6}, 5 | Expected Output: (1) | Output: " + execute(input, 5));

            int[] input2 = new int[]{1, 4, 1, 4, 5, 6};
            System.out.println("Input: {1, 4, 1, 4, 5, 6}, 6 | Expected Output: (1) | Output: " + execute(input2, 6));

            int[] input3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
            System.out.println("Input: {0, 1, 2, 3, 4, 5, 6, 7, 8}, 6 | Expected Output: (1) | Output: " + execute(input3, 6));

            int[] input4 = new int[]{1, 4, 1};
            System.out.println("Input: {1, 4, 1}, 5 | Expected Output: (0) | Output: " + execute(input4, 5));

            int[] input5 = new int[]{} ;
            System.out.println("Input: {}, 0 | Expected Output: (0) | Output: " + execute(input5, 0));

            int[] input6 = new int[]{8, -8, 8, 8, 7, 7, -7} ;
            System.out.println("Input: {8, -8, 8, 8, 7, 7, -7}, 0 | Expected Output: (0) | Output: " + execute(input6, -15));

            int[] input7 = new int[]{8, 8, 8, 8, 7, 7, 7} ;
            System.out.println("Input: {8, 8, 8, 8, 7, 7, 7}, 15 | Expected Output: (0) | Output: " + execute(input7, 15));

            int[] input8 = new int[]{3} ;
            System.out.println("Input: {3}, 0 | Expected Output: (0) | Output: " + execute(input8, 0));

        }

        static int execute(int[ ] a, int n)  {
           if(a.length < 1) return 0;
           if(n <= 0) return 0;
           int maximunSumOfIndex = a.length -1 + a.length -2;
           if(n > maximunSumOfIndex) return 0;

            for(int index = 0; index < a.length; index++){
                int indexToSum = (n - index) < 0 ? (n - index) * -1 : n - index;
                if(indexToSum != index && indexToSum < a.length){
                    if(index + indexToSum == n && a[index] + a[indexToSum] == n) return 1;
                }
            }
            return 0;
        }

    }