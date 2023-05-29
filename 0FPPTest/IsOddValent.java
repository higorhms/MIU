public class IsOddValent {
        public static void main(String[] args) {
            int[] input = new int[]{9, 3, 4, 9, 1} ;
            System.out.println("Input: {9, 3, 4, 9, 1}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{3, 3, 3, 3};
            System.out.println("Input: {3, 3, 3, 3} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{8, 8, 8, 4, 4, 7, 2};
            System.out.println("Input: {8, 8, 8, 4, 4, 7, 2} | Expected Output: (1) | Output: " + execute(input3));

            int[] input4 = new int[]{1, 2, 3, 4, 5} ;
            System.out.println("Input: {1, 2, 3, 4, 5} | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{2, 2, 2, 4, 4} ;
            System.out.println("Input: {2, 2, 2, 4, 4} | Expected Output: (0) | Output: " + execute(input5));
        }

        static int execute(int[ ] a)  {
            if(a.length < 2) return 0;

            boolean hasDuplicates = false;
            boolean hasOdd = false;

            for(int index = 0; index < a.length ; index++){
                if(a[index] % 2 != 0) hasOdd = true;

                for(int secondIndex = index + 1; secondIndex < a.length; secondIndex ++){
                    if(a[index] == a[secondIndex]) hasDuplicates = true;
                }
            }

            if(!hasDuplicates || !hasOdd) return 0;

            return 1;
        }

        static boolean contains(int value, int[] arr){
            for(int number : arr){
                if(value == number) return true;
            }
            return false;
        }
    }
