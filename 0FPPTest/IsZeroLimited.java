public class IsZeroLimited {
        public static void main(String[] args) {
            int[] input = new int[]{0, 0, 0, 0, 0} ;
            System.out.println("Input: {0, 0, 0, 0, 0}  | Expected Output: (0) | Output: " + execute(input));

            int[] input2 = new int[]{1, 0};
            System.out.println("Input: {1, 0} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{0, 1} ;
            System.out.println("Input: {0, 1} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{5};
            System.out.println("Input: {5} | Expected Output: (1) | Output: " + execute(input4));

            int[] input5 = new int[]{1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0};
            System.out.println("Input: {1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0} | Expected Output: (1) | Output: " + execute(input5));

            int[] input6 = new int[]{};
            System.out.println("Input: {} | Expected Output: (1) | Output: " + execute(input6));
        }

        static int execute(int[ ] a)  {
            if(a.length < 1) return 1;

            int indexShouldBeZero = 1;

            for(int index = 0; index < a.length; index++){
                if(index != indexShouldBeZero && a[index] == 0) return 0;

                if(index == indexShouldBeZero){
                    indexShouldBeZero = indexShouldBeZero + 3;
                    if(a[index] != 0) return 0;
                }
            }

            return 1;
        }


    }
