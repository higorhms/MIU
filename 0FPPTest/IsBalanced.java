public class IsBalanced {
        public static void main(String[] args) {
            int[] input = new int[]{-2, 3, 2, -3} ;
            System.out.println("Input: {-2, 3, 2, -3}  | Expected Output: (1) | Output: " + isBalanced(input));

            int[] input2 = new int[]{-2, 2, 2, 2};
            System.out.println("Input: {-2, 2, 2, 2} | Expected Output: (1) | Output: " + isBalanced(input2));

            int[] input3 = new int[] {-5, 2, -2};
            System.out.println("Input: {-5, 2, -2} | Expected Output: (0) | Output: " + isBalanced(input3));
        }

        static int isBalanced(int[ ] a)  {
            if(a.length < 2) return 0;

            for(int value : a){
                boolean contains = contains(value * -1, a);

                if(!contains) return 0;
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