public class IsFilterArray {
        public static void main(String[] args) {
            int[] input = new int[]{1, 2, 3, 9, 6, 11} ;
            System.out.println("Input: {1, 2, 3, 9, 6, 11}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{3, 4, 6, 7, 14, 16};
            System.out.println("Input: {3, 4, 6, 7, 14, 16} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[] {1, 2, 3, 4, 10, 11, 13};
            System.out.println("Input: {1, 2, 3, 4, 10, 11, 13} | Expected Output: (1) | Output: " + execute(input3));

            int[] input4 = new int[]{3, 6, 5, 5, 13, 6, 13};
            System.out.println("Input: {3, 6, 5, 5, 13, 6, 13} | Expected Output: (1) | Output: " + execute(input4));

            int[] input5 = new int[]{9, 6, 18} ;
            System.out.println("Input: {9, 6, 18}  | Expected Output: (0) | Output: " + execute(input5));

            int[] input6 = new int[]{4, 7, 13};
            System.out.println("Input: {4, 7, 13} | Expected Output: (0) | Output: " + execute(input6));
        }

        static int execute(int[ ] a)  {

            for(int value : a){
               if(value == 9 && !contains(11, a)) return 0;
               if(value == 7 && contains(13, a)) return 0;
            }

            return 1;
        }

        static boolean contains(int value, int[] arr){
            for(int number : arr){
                if(value == number) return true;
            }
            return false;
        }
    }