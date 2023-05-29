public class IsHollow2 {
        public static void main(String[] args) {
            int[] input = new int[]{1,2,0,0,0,3,4};
            System.out.println("Input: {1,2,0,0,0,3,4} | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{1,1,1,1,0,0,0,0,0,2,1,2,18};
            System.out.println("Input: {1,1,1,1,0,0,0,0,0,2,1,2,18} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{1, 2, 0, 0, 3, 4};
            System.out.println("Input: {1, 2, 0, 0, 3, 4} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{1,2,0,0,0,3,4,5} ;
            System.out.println("Input: {1,2,0,0,0,3,4,5}  | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{3,8,3,0,0,0,3,3} ;
            System.out.println("Input: {3,8,3,0,0,0,3,3}  | Expected Output: (0) | Output: " + execute(input5));

            int[] input6 = new int[]{1,2,0,0,0,3,4,0} ;
            System.out.println("Input: {1,2,0,0,0,3,4,0}  | Expected Output: (0) | Output: " + execute(input6));

            int[] input7 = new int[]{0,1,2,0,0,0,3,4} ;
            System.out.println("Input: {0,1,2,0,0,0,3,4}  | Expected Output: (0) | Output: " + execute(input7));

            int[] input8 = new int[]{0,0,0};
            System.out.println("Input: {0,0,0}  | Expected Output: (1) | Output: " + execute(input8));
        }

        static int execute(int[] input) {
            if(input.length < 3) return 0;
            int quantity = countZeros(input);
            if(quantity < 3 ) return 0;

           int countLeft = 0;
           int countRight = 0;

           for(int index = 0; index < input.length; index++){
               if(input[index] == 0) break;
               countLeft++;
           }

            for(int index = input.length - 1; index >= 0; index--){
                if(input[index] == 0) break;
                countRight++;
            }

            if(countLeft != countRight) return 0;

            return 1;
        }

        static int countZeros(int[] arr){
            int count = 0;

            for(int number : arr){
                if(number == 0) count++;
            }

            return count;
        }
    }
