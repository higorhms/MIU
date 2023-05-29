public class CountOnes {
        public static void main(String[] args) {
//            System.out.println("Input: 9 | Expected Output: (2) | Output: " + execute(9));
//            System.out.println("Input: 5  | Expected Output: (2) | Output: " + execute(5));
            System.out.println("Input: 15 | Expected Output: (4) | Output: " + execute(15));
        }

        static int execute(int n) {
            int countOnes = 0;
            while (n != 0){
                if(n % 2 == 1)
                    countOnes++;
                n /= 2;
            }
            return countOnes;
        }
    }