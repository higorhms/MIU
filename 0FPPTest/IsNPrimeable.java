public class IsNPrimeable {
        public static void main(String[] args) {
            int[] input = new int[]{5, 15, 27};
            System.out.println("Input: {5, 15, 27}, 2 | Expected Output: (1) | Output: " + execute(input, 2));

            int[] input2 = new int[]{5, 15, 27};
            System.out.println("Input: {5, 15, 27}, 3 | Expected Output: (0) | Output: " + execute(input2, 3));

            int[] input3 = new int[]{5, 15, 26};
            System.out.println("Input: {5, 15, 26}, 2 | Expected Output: (0) | Output: " + execute(input3, 2));

            int[] input4 = new int[]{1, 1, 1, 1, 1, 1, 1} ;
            System.out.println("Input: {1, 1, 1, 1, 1, 1, 1}, 4 | Expected Output: (1) | Output: " + execute(input4, 4));

            int[] input5 = new int[]{} ;
            System.out.println("Input: {}, 2 | Expected Output: (1) | Output: " + execute(input5, 2));

        }

        static int execute(int[ ] a, int n)  {
            if(a.length == 0) return 1;

            for(int number : a){
                if(!isPrime(number + n)) return 0;
            }

            return 1;
        }

        static boolean isPrime(int value){
            if(value < 2) return false;

            for(int index = 2; index < value; index++){
                if(value % index == 0) return false;
            }

            return true;
        }
    }