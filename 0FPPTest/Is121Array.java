public class Is121Array {
        public static void main(String[] args) {
            int[] input = new int[]{1, 2, 1};
            System.out.println("Input: {1, 2, 1} | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{1, 1, 2, 2, 2, 1, 1};
            System.out.println("Input: {1, 1, 2, 2, 2, 1, 1} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{1, 1, 2, 2, 2, 1, 1, 1};
            System.out.println("Input: {1, 1, 2, 2, 2, 1, 1, 1} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{1, 1, 1, 2, 2, 2, 1, 1} ;
            System.out.println("Input: {1, 1, 1, 2, 2, 2, 1, 1} | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1, 3} ;
            System.out.println("Input: {1, 1, 1, 2, 2, 2, 1, 1, 1, 3} | Expected Output: (0) | Output: " + execute(input5));

            int[] input6 = new int[]{1, 1, 1, 1, 1, 1};
            System.out.println("Input: {1, 1, 1, 1, 1, 1} | Expected Output: (0) | Output: " + execute(input6));

            int[] input7 = new int[]{2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1};
            System.out.println("Input: {2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1} | Expected Output: (0) | Output: " + execute(input7));

            int[] input8 = new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2};
            System.out.println("Input: {1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2} | Expected Output: (0) | Output: " + execute(input8));

            int[] input9 = new int[]{2, 2, 2};
            System.out.println("Input: {2, 2, 2} | Expected Output: (0) | Output: " + execute(input9));
        }

        static int execute(int[ ] a)  {
            if(a.length < 3) return 0;
            boolean hasNumberTwo = false;

            //verifiry if it contains only 2 and 1
            for(int index = 0; index < a.length; index++){
                if(a[index] != 1 && a[index] != 2) return 0;
                if(a[index] == 2) hasNumberTwo = true;
            }

            //count Ones on the left
            int countOnesLeft = 0;
            for(int index = 0; index < a.length; index++){
                if(a[index] != 1) break;
                if(a[index] == 1) countOnesLeft++;
            }

            //count Ones on the right
            int countOnesRight = 0;
            for(int index = a.length - 1; index >= 0; index--){
                if(a[index] != 1) break;
                if(a[index] == 1) countOnesRight++;
            }

            //check if at least one number one is on the array
            if(countOnesLeft < 1 || countOnesRight < 1 || !hasNumberTwo) return 0;

            return countOnesLeft == countOnesRight ? 1 : 0;
        }
    }