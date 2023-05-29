public class IsNormal {
        public static void main(String[] args) {
            System.out.println("Input: 1 | Expected Output: (1) | Output: " + execute(1));
            System.out.println("Input: 2 | Expected Output: (1) | Output: " + execute(2));
            System.out.println("Input: 3 | Expected Output: (1) | Output: " + execute(3));
            System.out.println("Input: 4 | Expected Output: (1) | Output: " + execute(4));
            System.out.println("Input: 5 | Expected Output: (1) | Output: " + execute(5));
            System.out.println("Input: 6 | Expected Output: (0) | Output: " + execute(6));
            System.out.println("Input: 7 | Expected Output: (1) | Output: " + execute(7));
            System.out.println("Input: 8 | Expected Output: (1) | Output: " + execute(8));
            System.out.println("Input: 9 | Expected Output: (0) | Output: " + execute(9));
            System.out.println("Input: 10 | Expected Output: (0) | Output: " + execute(10));
        }

        static int execute(int n) {
            if(n == 1 ) return 1;

            for(int index = 2; index < n; index++){
                if(n % index == 0 && index % 2 != 0) return 0;
            }

            return 1;
        }
    }