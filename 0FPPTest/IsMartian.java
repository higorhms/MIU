public class IsMartian {
        public static void main(String[] args) {
            int[] input = new int[]{1, 3} ;
            System.out.println("Input: {1, 3}  | Expected Output: (1) | Output: " + execute(input));

            int[] input2 = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1};
            System.out.println("Input: {1, 2, 1, 2, 1, 2, 1, 2, 1} | Expected Output: (1) | Output: " + execute(input2));

            int[] input3 = new int[]{1, 3, 2};
            System.out.println("Input: {1, 3, 2} | Expected Output: (0) | Output: " + execute(input3));

            int[] input4 = new int[]{1, 3, 2, 2, 1, 5, 1, 5} ;
            System.out.println("Input: {1, 3, 2, 2, 1, 5, 1, 5}  | Expected Output: (0) | Output: " + execute(input4));

            int[] input5 = new int[]{1, 2, -18, -18, 1, 2} ;
            System.out.println("Input: {1, 2, -18, -18, 1, 2}  | Expected Output: (0) | Output: " + execute(input5));

            int[] input6 = new int[]{};
            System.out.println("Input: {} | Expected Output: (0) | Output: " + execute(input6));

            int[] input7 = new int[]{1};
            System.out.println("Input: {1} | Expected Output: (1) | Output: " + execute(input7));

            int[] input8 = new int[]{2};
            System.out.println("Input: {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10} | Expected Output: (0) | Output: " + execute(input8));
        }

        //Essa logica nao funcionaria caso o conteudo do array (a) contenha o numero 0,
        // ja que o new int[] do java inicializa sempre com as posicoes zeradas, o numero zero nao seria calculado
        static int execute(int[ ] a)  {
            if(a.length == 0) return 0;
            if(a.length == 1 && a[0] != 1) return 0;
            if(a.length == 1 && a[0] == 1) return 1;

            int numberOfOnes = 0;
            int numberOfTwo = 0;
            int index = 0;


            while(index < a.length){
                if(index != 0 &&  a[index] == a[index - 1]) return 0;
                if(a[index] == 1) numberOfOnes++;
                if(a[index] == 2) numberOfTwo++;
                index++;
            }

            if(numberOfOnes > numberOfTwo ) return 1;

            return 0;
        }

        static boolean contains(int value, int[] arr){
            for(int number : arr){
                if(value == number) return true;
            }

            return false;
        }

    }
