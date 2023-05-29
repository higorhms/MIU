public class LargestAdjacentSum {
        public static void main(String[] args) {
            int[] input = new int[]{1, 2, 3, 4} ;
            System.out.println("Input: {1, 2, 3, 4}  | Expected Output: (7) | Output: " + execute(input));

            int[] input2 = new int[]{18, -12, 9, -10};
            System.out.println("Input: {18, -12, 9, -10} | Expected Output: (6) | Output: " + execute(input2));

            int[] input3 = new int[]{1,1,1,1,1,1,1,1,1};
            System.out.println("Input: {1,1,1,1,1,1,1,1,1} | Expected Output: (2) | Output: " + execute(input3));

            int[] input4 = new int[] {1,1,1,1,1,2,1,1,1};
            System.out.println("Input: {1,1,1,1,1,2,1,1,1} | Expected Output: (3) | Output: " + execute(input4));
        }

        static int execute(int[ ] a)  {
            if(a.length < 2) return 0;

            int highestSum = 0;

            for(int index = 1; index < a.length; index++){
                int aux = a[index] + a[index -1];
                if(aux > highestSum) highestSum = aux;
            }

            return highestSum;
        }
    }