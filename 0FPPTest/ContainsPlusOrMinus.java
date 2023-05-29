public class ContainsPlusOrMinus {

        public static void main(String[] args) {
            int[] input = new int[]{3, 4, 5, 7} ;

            System.out.println(execute(input));
        }

    static int execute(int[] arr) {
            for(int number : arr){
                boolean flag = false;

                flag = containsValue(number + 1, arr);

                if(!flag) flag = containsValue(number - 1, arr);

                if(!flag) return 0;
            }

            return 1;
        }

        static boolean containsValue(int value, int[] arr){
            for(int number : arr){
                if(number == value) return true;
            }

            return false;
        }
    }

