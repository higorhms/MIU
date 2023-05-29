public class IsEvens {
        public static void main(String[] args) {
            System.out.println("Input: 3224 | Expected Output: (0) | Output: " + execute(3224));
            System.out.println("Input: 2426 | Expected Output: (1) | Output: " + execute(2426));
        }

        static int execute (int n){

            while(n > 0){
                int lastDigit = n % 10;

                if(lastDigit % 2 != 0) return 0;

                n = n / 10;
            }

            return 1;
        }
    }