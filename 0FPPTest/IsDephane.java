public class IsDephane {
        public static void main(String[] args) {
            int[] input = new int[]{2, 4, 2} ;
            System.out.println("Input: {2, 4, 2}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{1, 3, 17, -5};
            System.out.println("Input: {1, 3, 17, -5} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{3, 2, 5} ;
            System.out.println("Input: {3, 2, 5}  | Expected Output: (0) | Output: " + execute(input3));
        }

        static int execute(int[ ] a)  {
            if(a.length == 0) return 0;

            int firstElementIsOddOrEven = a[0] % 2;

            if(firstElementIsOddOrEven == 0){
                for(int number : a){
                    if(number % 2 != 0) return 0;
                }
            }

            if(firstElementIsOddOrEven != 0){
                for(int number : a){
                    if(number % 2 == 0) return 0;
                }
            }

            return 1;
        }
    }
