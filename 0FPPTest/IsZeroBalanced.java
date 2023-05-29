public class IsZeroBalanced {
        public static void main(String[] args) {
            int[] input = new int[]{1, 2, -2, -1} ;
            System.out.println("Input: {1, 2, -2, -1}  | Expected Output: (1) | Output: " + isBalanced(input));

            int[] input2 = new int[]{-3, 1, 2, -2, -1, 3};
            System.out.println("Input: {-3, 1, 2, -2, -1, 3} | Expected Output: (1) | Output: " + isBalanced(input2));

            int[] input3 = new int[]{0, 0, 0, 0, 0, 0};
            System.out.println("Input: {0, 0, 0, 0, 0, 0} | Expected Output: (1) | Output: " + isBalanced(input3));

            int[] input4 = new int[] {3, 4, -2, -3, -2};
            System.out.println("Input: {3, 4, -2, -3, -2} | Expected Output: (0) | Output: " + isBalanced(input4));

            int[] input5 = new int[]{3, -3, -3};
            System.out.println("Input: {3, -3, -3} | Expected Output: (0) | Output: " + isBalanced(input5));

            int[] input6 = new int[]{3};
            System.out.println("Input: {3} | Expected Output: (0) | Output: " + isBalanced(input6));

            int[] input7 = new int[]{};
            System.out.println("Input: {} | Expected Output: (0) | Output: " + isBalanced(input7));
        }

        static int isBalanced(int[ ] a)  {
            if(a.length < 1) return 0;

            int sum = 0;

            for(int number : a ){
                if(!contains(number * - 1, a)) return 0;

                sum += number;
            }

            if(sum != 0) return 0;

            return 1;
        }

        static boolean contains(int value, int[] arr){
            for(int number : arr){
                if(number == value) return true;
            }
            return false;
        }

    }