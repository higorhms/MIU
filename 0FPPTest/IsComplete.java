public class IsComplete {

        public static void main(String[] args) {
            int[] input = new int[]{36, -28};
            System.out.println("Input: {36, -28} | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{36, 28};
            System.out.println("Input: {36, 28} | Expected Output: (0) | Output: " + execute(input2));

            int[] input3 = new int[]{4};
            System.out.println("Input: {4} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{3, 2, 1, 1, 5, 6};
            System.out.println("Input: {3, 2, 1, 1, 5, 6} | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{3, 7, 23, 13, 107, -99, 97, 81} ;
            System.out.println("Input: {3, 7, 23, 13, 107, -99, 97, 81}  | Expected Output: (0) | Output: " + execute(input5));

        }

        static int execute(int[ ] a)  {
            if(a.length < 2) return 0;

            boolean hasEven = false;
            boolean hasTwoValuesThatSumsEight = false;
            boolean hasPerfectSquare = false;

            for(int index = 0; index < a.length; index++){
                if(a[index] % 2 == 0) hasEven = true;
                if(isSquare(a[index]) == 1) hasPerfectSquare = true;

                for(int secondIndex = 0; secondIndex < a.length; secondIndex++){
                    if(a[index] != a[secondIndex] && a[index] + a[secondIndex] == 8) hasTwoValuesThatSumsEight = true;
                }

                if(hasEven && hasTwoValuesThatSumsEight && hasPerfectSquare) return 1;
            }

            return 0;
        }

        static int isSquare(int value){
            if(value < 0) return 0;

            for(int index = 0; index <= value; index++){
                if(index * index == value) return 1;
            }

            return 0;
        }


    }