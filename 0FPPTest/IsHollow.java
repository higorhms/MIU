public class IsHollow {
        public static void main(String[] args) {
            int[] input = new int[]{1,2,4,0,0,0,3,4,5};
            System.out.println("{1,2,4,0,0,0,3,4,5} (1): " + isHollow(input));

            int[] input2 = new int[]{1,2,0,0,0,3,4,5};
            System.out.println("{1,2,0,0,0,3,4,5} (0): " + isHollow(input2));

            int[] input3 = new int[]{1,2,4,9,0,0,0,3,4,5};
            System.out.println("{1,2,0,0,0,3,4,5} (0): " + isHollow(input3));

            int[] input4 = new int[]{1,2, 0,0, 3,4};
            System.out.println("{1,2, 0,0, 3,4} (0): " + isHollow(input4));

            int[] input5 = new int[]{1,2,3,4,5,0,0,0,0,0,1,2,3,4,5};
            System.out.println("{1,2,3,4,5,0,0,0,0,0,1,2,3,4,5} (1): " + isHollow(input5));
        }

        static int isHollow(int[] input) {
          if(input.length < 9) return 0;

          int quantityOfZeros = countZeros(input);

          if(input.length % quantityOfZeros != 0) return 0;

          for(int index = quantityOfZeros; index < quantityOfZeros * 2; index++){
              if(input[index] != 0) return 0;
          }

          return 1;
        }

        static int countZeros(int[] arr){
            int count = 0;

            for(int number : arr){
                if(number == 0) count++;
            }

            return count;
        }
    }