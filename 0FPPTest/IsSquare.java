public class IsSquare {
        public static void main(String[] args) {
            System.out.println("Input: 4  | Expected Output: (1) | Output: " + execute(4));
            System.out.println("Input: 25  | Expected Output: (1) | Output: " + execute(25));
            System.out.println("Input: -4 | Expected Output: (0) | Output: " + execute(-1));
            System.out.println("Input: 8  | Expected Output: (0) | Output: " + execute(8));
            System.out.println("Input: 0  | Expected Output: (1) | Output: " + execute(0));

        }

        static int execute(int n) {
            if(n < 0) return 0;

           for(int index = 0; index <= n; index++){
               if(index * index == n) return 1;
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