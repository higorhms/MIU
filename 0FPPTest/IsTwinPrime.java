public class IsTwinPrime {
        public static void main(String[] args) {
            System.out.println("Input: 5  | Expected Output: (1) | Output: " + execute(5));
            System.out.println("Input: 7  | Expected Output: (1) | Output: " + execute(7));
            System.out.println("Input: 53 | Expected Output: (0) | Output: " + execute(53));
            System.out.println("Input: 9 | Expected Output: (0) | Output: " + execute(9));
        }

        static int execute(int n) {
            if(n < 2) return 0;

            boolean isTwin = false;
            boolean valueIsPrime = isPrime(n);

            if(!valueIsPrime) return 0;

            if(isPrime(n + 2)) isTwin = true;
            if(isPrime(n - 2)) isTwin = true;

            if(!isTwin) return 0;

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
