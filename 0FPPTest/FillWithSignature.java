import java.util.Arrays;

public class FillWithSignature {
        public static void main(String[] args) {
            int[] input = new int[]{1,2,3,5, 9, 12,-2,-1};
            System.out.println("Input: {1,2,3,5, 9, 12,-2,-1} | Expected Output: ({1,2,3,1,2,3,1,2,3,1}) | Output: " + Arrays.toString(fill(input, 3, 10)));

            int[] input2 = new int[]{4, 2, -3, 12};
            System.out.println("{4, 2, -3, 12} ({4, 4, 4, 4, 4}): " + Arrays.toString(fill(input2, 1, 5)));

            int[] input3 = new int[]{2, 6, 9, 0, -3};
            System.out.println("{2, 6, 9, 0, -3} (null): " + fill(input3 , 0, 4));

        }

        static int[ ] fill(int[ ] arr, int k, int n)  {
            if(k < 1 || n < 1) return null;

            int[] aux = new int[n];
            int index = 0;
            int indexAux = 0;
            int elementsAdded = 0;

            while(elementsAdded < n){
                aux[indexAux] = arr[index];
                index++;
                indexAux++;
                elementsAdded++;

                if(index >= k) index = 0;
            }

            return aux;
        }


    }