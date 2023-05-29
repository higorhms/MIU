public class ArrayContainTwins {
        public static void main(String[] args) {
            int[] input = new int[]{4, 7, 9, 6, 5} ;
            System.out.println("Input: {4, 7, 9, 6, 5}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{4, 9, 6, 33};
            System.out.println("Input: {4, 9, 6, 33} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{3, 8, 15};
            System.out.println("Input: {3, 8, 15} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{3};
            System.out.println("Input: {3} | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{67};
            System.out.println("Input: {67} | Expected Output: (1) | Output: " + execute(input5));
        }

        static int execute(int[ ] a)  {

            for(int value : a){
                boolean hasPrime = false;
                boolean hasTwin = false;

                if(isPrime(value) == 1){
                    hasPrime = true;

                    if(isPrime(value + 2) == 1 && contains(value + 2, a)) hasTwin = true;
                    if(isPrime(value - 2) == 1 && contains(value - 2, a)) hasTwin = true;

                }

                if(((isPrime(value + 2)) == 1 || isPrime(value - 2) == 1) && !hasTwin && hasPrime) return 0;
            }

           return 1;
        }

        static int isPrime(int value){
            if(value < 2) return 0;

            for(int index = 2; index < value; index++){
                if(value % index == 0 ) return 0;
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