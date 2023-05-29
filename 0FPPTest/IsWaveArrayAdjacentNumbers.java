public class IsWaveArrayAdjacentNumbers {
        public static void main(String[] args) {
            int[] arr = new int[]  {2}  ;

            System.out.println(isWave(arr));
        }

        static int isWave(int[] input) {
            if(input.length == 1) return 1;

            for(int index = 0; index < input.length - 1; index++){
                if(input[index] % 2 == 0 && input[index + 1]%2 == 0) return 0;
                if(input[index] % 2 != 0 && input[index + 1]%2 != 0) return 0;
            }

            return 1;
        }
    }