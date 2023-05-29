public class PrimeCount {
        public static void main(String[] args) {
            System.out.println("Input: 10,30  | Expected Output: (6) | Output: " + execute(10, 30));
            System.out.println("Input: 11,29  | Expected Output: (6) | Output: " + execute(11, 29));
            System.out.println("Input: 20,22 | Expected Output: (0) | Output: " + execute(20, 22));
            System.out.println("Input: 1,1 | Expected Output: (0) | Output: " + execute(1, 1));
            System.out.println("Input: 5,5 | Expected Output: (1) | Output: " + execute(5, 5));
            System.out.println("Input: 6,2 | Expected Output: (0) | Output: " + execute(6, 2));
            System.out.println("Input: -10,6 | Expected Output: (3) | Output: " + execute(-10, 6));
        }

        static int execute(int start, int end) {
            if( start > end) return 0;

            int countPrimes = 0;

            for(int index = start; index <= end; index++){
                if(isPrime(index)) countPrimes++;
            }

            return countPrimes;
        }

        static boolean isPrime(int value){
            if(value < 2) return false;

            for(int index = 2; index < value; index++){
                if(value % index == 0) return false;
            }

            return true;
        }
    }
