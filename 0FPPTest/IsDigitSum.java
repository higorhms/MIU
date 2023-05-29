public class IsDigitSum {
        public static void main(String[] args) {
            System.out.println("Input: 32121,10  | Expected Output: (1) | Output: " + execute(32121, 10));
            System.out.println("Input: 32121,9  | Expected Output: (0) | Output: " + execute(32121, 9));
            System.out.println("Input: 13, 6 | Expected Output: (1) | Output: " + execute(13, 6));
            System.out.println("Input: 3, 3 | Expected Output: (0) | Output: " + execute(3, 3));
            System.out.println("Input: -543, 3 | Expected Output: (-1) | Output: " + execute(-543, 3));
        }

        static int execute(int n, int m) {
            if(n < 0 || m < 0) return -1;
            int sum = 0;

            while(n > 0){
                sum += n % 10;
                n = n / 10;
            }

            if(sum < m) return 1;

            return 0;
        }
}