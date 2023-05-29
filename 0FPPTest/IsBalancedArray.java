public class IsBalancedArray {
        public static void main(String[] args) {
            int[] input = new int[]{2, 3, 6, 7} ;
            System.out.println("Input: {2, 3, 6, 7}  | Expected Output: (1) | Output: " + isBalanced(input));

            int[] input2 = new int[]{6, 7, 2, 3, 12};
            System.out.println("Input: {6, 7, 2, 3, 12} | Expected Output: (1) | Output: " + isBalanced(input2));

            int[] input3 = new int[]{7, 15, 2, 3};
            System.out.println("Input: {7, 15, 2, 3} | Expected Output: (0) | Output: " + isBalanced(input3));

            int[] input4 = new int[]{16, 6, 2, 3} ;
            System.out.println("Input: {16, 6, 2, 3}  | Expected Output: (0) | Output: " + isBalanced(input4));

        }

        static int isBalanced(int[ ] a)  {
            if(a.length < 2) return 0;

            for(int index = 0; index < a.length; index++){
                if(index % 2 == 0){
                    if(a[index] % 2 != 0) return 0;
                }

                if(index % 2 != 0){
                    if(a[index] % 2 == 0) return 0;
                }
            }

            return 1;
        }


    }