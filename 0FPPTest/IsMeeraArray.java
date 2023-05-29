public class IsMeeraArray {

        public static void main(String[] args) {
            int[] input = new int[]{-8, 0, 0, 8, 0};

            System.out.println(new TesteIsMeeraArray().isMeeraArray(input));
        }
    }

    class TesteIsMeeraArray {
        public int isMeeraArray(int[ ] a) {
            int sum = 0;

            for(int index = 0; index < a.length ; index++){
                if(a[index] > index) return 0;

                sum = sum + a[index];
            }

            if(sum == 0) return 1;

            return 0;
        }
    }

