public class IsCubePerfect {
        public static void main(String[] args) {
            int[] input = new int[]{1, 1, 1, 1} ;
            System.out.println("Input: {1, 1, 1, 1}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{64};
            System.out.println("Input: {64} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{63} ;
            System.out.println("Input: {63} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{-1, 0, 1};
            System.out.println("Input: {-1, 0, 1} | Expected Output: (1) | Output: " + execute(input4));

            int[] input5 = new int[]{64};
            System.out.println("Input: {} | Expected Output: (1) | Output: " + execute(input5));

            int[] input6 = new int[]{3, 7, 21, 36};
            System.out.println("Input: {3, 7, 21, 36} | Expected Output: (0) | Output: " + execute(input6));
        }

        static int execute(int[ ] a)  {
            if(a.length < 1) return 1;

            for(int number : a){
                boolean flagIsOk = false;

                if(number > 0){
                    for(int index = 0; index <= number; index++){
                        if((index * index * index) == number) flagIsOk = true;
                    }
                }

                if(number < 1){
                    for(int index = 0; index >= number; index--){
                        if((index * index * index) == number) flagIsOk = true;
                    }
                }

                if(!flagIsOk) return 0;
            }


            return 1;
        }


    }
