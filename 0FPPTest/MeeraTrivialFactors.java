public class MeeraTrivialFactors {
        public static void main(String[] args) {
            System.out.println(execute(2));
        }

        static int execute(int number) {
            if(number < 2) return 0;

            int count = 0;

            for(int index = 2; index < number; index++){
                if(number%index == 0) count++;
            }

            if(count == 0) return 0;
            if(number % count == 0) return 1;

            return 0;
        }
    }

