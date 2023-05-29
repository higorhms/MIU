import java.util.Arrays;

public class ComputeHMS {
        public static void main(String[] args) {
            System.out.println("Input: 3735  | Expected Output: ({1, 2, 15}) | Output: " + Arrays.toString(execute(3735)));
            System.out.println("Input: 380  | Expected Output: ({0, 6, 20}) | Output: " + Arrays.toString(execute(380)));
            System.out.println("Input: 3650 | Expected Output: ({1, 0, 50}) | Output: " + Arrays.toString(execute(3650)));
            System.out.println("Input: 55 | Expected Output: ({0, 0, 55}) | Output: " + Arrays.toString(execute(55)));
            System.out.println("Input: 0 | Expected Output: ({0, 0, 0}) | Output: " + Arrays.toString(execute(0)));
        }

        static int[] execute(int seconds){
            int[] aux = new int[3];

            while (seconds > 3600){
                aux[0] += 1;
                seconds -= 3600;
            }

            while (seconds > 60){
                aux[1] += 1;
                seconds -= 60;
            }

            aux[2] = seconds;

            return aux;
        }
    }
