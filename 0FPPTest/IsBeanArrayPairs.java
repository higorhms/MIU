public class IsBeanArrayPairs {
        public static void main(String[] args) {
            int[] arr = new int[] {4, 7, 16} ;

            System.out.println(execute(arr));
        }

        static int execute(int[] input) {
            for(int number : input){
                if(number == 9 && !contains(13, input)) return 0;
                if(number == 7 && contains(16, input)) return 0;
            }

            return 1;
        }

        static boolean contains(int value, int[] arr){
            for(int number : arr){
                if(value == number) return true;
            }

            return false;
        }
    }

