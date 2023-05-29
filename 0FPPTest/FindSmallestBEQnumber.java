public class FindSmallestBEQnumber {
        public static void main(String[] args) {
            System.out.println("Input: 806  | Expected Output: (1) | Output: " + execute(806));
            System.out.println("Input: 36  | Expected Output: (0) | Output: " + execute(36));
            System.out.println("Input: 1118 | Expected Output: (0) | Output: " + execute(1118));
        }

        static int execute(long n) {

            int numberOfSix = 0;
            long valueToCheck = n * n * n;

            while(valueToCheck > 0){
                if(valueToCheck % 10 == 6) numberOfSix++;
                valueToCheck = valueToCheck / 10;
            }

            if(numberOfSix == 4) return 1;

            return 0;
        }
}
