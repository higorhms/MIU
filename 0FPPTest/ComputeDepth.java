public class ComputeDepth {
    public static void main(String[] args) {
        System.out.println("Input: 7  | Expected Output: (10) | Output: " + execute(7));
        System.out.println("Input: 13  | Expected Output: (8) | Output: " + execute(13));
        System.out.println("Input: 25 | Expected Output: (36) | Output: " + execute(25));
    }

    static int execute(int n){
        int count = 0;
        boolean flagDone = false;
        int[] auxArray = new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};

        while (flagDone == false){
            count++;
            int multiple = n * count;

            boolean containsEverything = true;

            while(multiple > 0){
                int digit = multiple % 10;
                auxArray[digit] = digit;
                multiple = multiple / 10;
            }

            for(int index = 0; index < 10; index++){
                if(auxArray[index] != index) containsEverything = false;
            }

            if(containsEverything){
                flagDone = true;
            }

        }

        return count;
    }
}
