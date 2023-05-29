public class ContinuousFactored {
        public static void main(String[] args) {
            System.out.println("Input: 24  | Expected Output: (1) | Output: " + execute(24));
            System.out.println("Input: 105  | Expected Output: (0) | Output: " + execute(105));
            System.out.println("Input: 90 | Expected Output: (1) | Output: " + execute(90));
            System.out.println("Input: 23  | Expected Output: (0) | Output: " + execute(23));
            System.out.println("Input: 15  | Expected Output: (0) | Output: " + execute(15));
            System.out.println("Input: 2 | Expected Output: (0) | Output: " + execute(2));
            System.out.println("Input: 0  | Expected Output: (0) | Output: " + execute(0));
            System.out.println("Input: -12  | Expected Output: (0) | Output: " + execute(-12));

        }

        static int execute(int n) {
            if(n < 2) return 0;

            for(int index = 2; index < n; index++){
                if(n % index == 0 && n % (index + 1) == 0) return 1;
            }

            return 0;
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