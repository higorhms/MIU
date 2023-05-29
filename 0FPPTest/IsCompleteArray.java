public class IsCompleteArray {
        public static void main(String[] args) {
            int[] input = new int[]{5, 7, 9, 13};
            System.out.println("Input: {5, 7, 9, 13} | Expected Output: (0) | Output: " + isComplete(input));

            int[] input2 = new int[]{2, 2};
            System.out.println("Input: {2, 2} | Expected Output: (0) | Output: " + isComplete(input2));

            int[] input3 = new int[]{2, 6, 3, 4};
            System.out.println("Input: {2, 6, 3, 4} | Expected Output: (0) | Output: " + isComplete(input3));

            int[] input4 = new int[]{-5, 6, 2, 3, 2, 4, 5, 11, 8, 7} ;
            System.out.println("Input: {-5, 6, 2, 3, 2, 4, 5, 11, 8, 7}  | Expected Output: (1) | Output: " + isComplete(input4));
        }

        static int isComplete (int[ ] a)  {
            int min = Integer.MAX_VALUE;
            int max = 0;
            boolean hasEven = false;

            for(int number : a){
                if(number < min && number % 2 == 0) min = number;
                if(max < number && number % 2 == 0) max = number;

                if(number % 2 == 0) hasEven = true;
            }

            if(min == max || !hasEven) return 0;

            for(int index = min + 1; index < max; index++){
                boolean containsNumber = false;

                for(int number : a){
                    if(number == index) containsNumber = true;
                }

                if(!containsNumber) return 0;
            }

            return 1;
        }
}