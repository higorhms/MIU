public class AllValuesTheSame {
        public static void main(String[] args) {
            int[] input = new int[]{1, 1, 1, 1} ;
            System.out.println("Input: {1, 1, 1, 1}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{83, 83, 83};
            System.out.println("Input: {83, 83, 83} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            System.out.println("Input: {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}| Expected Output: (1) | Output: " + execute(input3));

            int[] input4 = new int[]{1, -2343456, 1, -2343456};
            System.out.println("Input: {1, -2343456, 1, -2343456} | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{0, 0, 0, 0, -1} ;
            System.out.println("Input: {0, 0, 0, 0, -1}  | Expected Output: (0) | Output: " + execute(input5));

            int[] input6 = new int[]{432123456};
            System.out.println("Input: {432123456} | Expected Output: (1) | Output: " + execute(input6));

            int[] input7 = new int[]{-432123456};
            System.out.println("Input: {-432123456} | Expected Output: (1) | Output: " + execute(input7));

            int[] input8 = new int[]{};
            System.out.println("Input: {} | Expected Output: (0) | Output: " + execute(input8));
        }

        static int execute(int[ ] a)  {
            if(a.length == 0) return 0;
            if(a.length == 1) return 1;

            int firstElement = a[0];

            for(int number : a){
                if(number != firstElement) return 0;
            }

            return 1;
        }
    }
