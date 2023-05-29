public class IsLayered {
        public static void main(String[] args) {
            int[] input = new int[]{1, 1, 2, 2, 2, 3, 3};
            System.out.println("Input: {1, 1, 2, 2, 2, 3, 3} | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{3, 3, 3, 3, 3, 3, 3};
            System.out.println("Input: {3, 3, 3, 3, 3, 3, 3} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{1, 2, 2, 2, 3, 3};
            System.out.println("Input: {1, 2, 2, 2, 3, 3} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{2, 2, 2, 3, 3, 1, 1} ;
            System.out.println("Input: {2, 2, 2, 3, 3, 1, 1}   | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{2}  ;
            System.out.println("Input: {2}   | Expected Output: (0) | Output: " + execute(input5));

            int[] input6 = new int[]{}  ;
            System.out.println("Input: {}   | Expected Output: (0) | Output: " + execute(input6));
        }

        static  int execute (int[ ] a) {
            if(a.length < 2) return 0;


            for(int index = 0; index < a.length; index++){
                if(countValues(a[index], a) < 2) return 0;
            }

            for(int index =0; index < a.length -1; index++){
                if(a[index] > a[index+1]) return 0;
            }

            return 1;
        }

        static int countValues(int value, int[] arr){
            int count = 0;

            for(int number : arr){
                if(value == number) count++;
            }

            return count;
        }
    }
