public class SameNumberOfFactors {
        public static void main(String[] args) {
            System.out.println("Input: -6, 21  | Expected Output: (-1) | Output: " + execute(-6, 21));
            System.out.println("Input: 6, 21  | Expected Output: (1) | Output: " + execute(6, 21 ));
            System.out.println("Input: 8, 12 | Expected Output: (0) | Output: " + execute( 8, 12));
            System.out.println("Input: 23, 97  | Expected Output: (1) | Output: " + execute(23, 97 ));
            System.out.println("Input: 0, 1  | Expected Output: (0) | Output: " + execute(0, 1 ));
            System.out.println("Input: 0 , 0 | Expected Output: (1) | Output: " + execute(0 , 0));

        }

        static int execute(int n1, int n2) {
            if(n1 < 0 || n2 < 0) return -1;
            if(n1 == n2) return 1;

            if(countFactors(n1) != countFactors(n2)) return 0;

            return 1;
        }

        static int countFactors(int number){
            if(number == 0) return 0;
            int count = 0;

            for(int index = 1; index <= number; index++){
                if(number % index == 0) count++;
            }

            return count;
        }
    }





























//        static int isContinuousFactored(int n) {
//            for (int i = 2; i < n; i++) {
//                if (n % i == 0 && n % (i + 1) == 0) {
//                    return 1;
//                }
//            }
//
//            return 0;
//        }