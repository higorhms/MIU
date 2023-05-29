public class IsAllPossibilities {
        public static void main(String[] args) {
            int[] input = new int[]{1, 2, 0, 3} ;
            System.out.println("Input: {1, 2, 0, 3}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{3, 2, 1, 0};
            System.out.println("Input: {3, 2, 1, 0} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{1, 2, 4, 3};
            System.out.println("Input: {1, 2, 4, 3} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{0, 2, 3} ;
            System.out.println("Input: {0, 2, 3}  | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{0} ;
            System.out.println("Input: {0}  | Expected Output: (1) | Output: " + execute(input5));

            int[] input6 = new int[]{};
            System.out.println("Input: {} | Expected Output: (0) | Output: " + execute(input6));
        }

        static int execute(int[ ] a)  {
            if(a.length < 1) return 0;

          for(int index = 0; index < a.length; index++){
              if(!contains(index, a)) return 0;
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
