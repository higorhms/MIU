public class LoopSum {
        public static void main(String[] args) {
            int[] input = new int[]{1, 2, 3} ;
            System.out.println("Input: {1, 2, 3} | Expected Output: (3) | Output: " + execute(input, 2));

            int[] input2 = new int[]{-1, 2, -1};
            System.out.println("Input: {-1, 2, -1} | Expected Output: (-1) | Output: " + execute(input2, 7));

            int[] input3 = new int[]{1, 4, 5, 6};
            System.out.println("Input: {1, 4, 5, 6} | Expected Output: (16) | Output: " + execute(input3, 4));

            int[] input4 = new int[]{3};
            System.out.println("Input: {3} | Expected Output: (30) | Output: " + execute(input4, 10));
        }

        static int execute(int[ ] a, int n)  {
            if(a.length < 1) return 0;
            if(a.length == 1) return a[0] * n;

            int index = 0;
            int numberOfSumbs = n;
            int sums = 0;

            while (numberOfSumbs > 0){
                if(index == a.length) index = 0;

                sums += a[index];

                numberOfSumbs--;
                index++;
            }

            return sums;
        }
    }
