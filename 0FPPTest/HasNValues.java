public class HasNValues {
        public static void main(String[] args) {
            int[] input = new int[]{1, 2, 2, 1} ;
            System.out.println("Input: {1, 2, 2, 1}  | Expected Output: (1) | Output: " + execute(input, 2));

            int[] input2 = new int[]{1, 1, 1, 8, 1, 1, 1, 3, 3};
            System.out.println("Input: {1, 1, 1, 8, 1, 1, 1, 3, 3} | Expected Output: (1) | Output: " + execute(input2, 3));

            int[] input3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};
            System.out.println("Input: {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10} | Expected Output: (1) | Output: " + execute(input3, 10));

            int[] input4 = new int[]{1, 2, 2, 1} ;
            System.out.println("Input: {1, 2, 2, 1}  | Expected Output: (0) | Output: " + execute(input4, 3));

            int[] input5 = new int[]{1, 1, 1, 8, 1, 1, 1, 3, 3} ;
            System.out.println("Input: {1, 1, 1, 8, 1, 1, 1, 3, 3}  | Expected Output: (0) | Output: " + execute(input5, 2));

            int[] input6 = new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};
            System.out.println("Input: {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10} | Expected Output: (0) | Output: " + execute(input6, 20));
        }

        //Essa logica nao funcionaria caso o conteudo do array (a) contenha o numero 0,
        // ja que o new int[] do java inicializa sempre com as posicoes zeradas, o numero zero nao seria calculado
        static int execute(int[ ] a, int n)  {
            if(a.length == 0) return 0;
            if(a.length == 1) return 1;

            int countDifferentValues = 0;
            int[] aux = new int[a.length];

            for(int index = 0; index < a.length; index ++){
                if(!contains(a[index], aux)) {
                    aux[index] = a[index];
                    countDifferentValues++;
                }
            }

            if(countDifferentValues != n) return 0;

            return 1;
        }

        static boolean contains(int value, int[] arr){
            for(int number : arr){
                if(value == number) return true;
            }

            return false;
        }

    }
