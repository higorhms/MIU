public class IsTripleArray {
        public static void main(String[] args) {
            int[] input = new int[]{3, 1, 1, 1};

            System.out.println(new TesteIsTripleArray().execute(input));
        }
    }

    class TesteIsTripleArray {
        public int execute(int[] n) {
            if(n.length < 3) return 0;

            for(int index = 0; index < n.length ; index++){
                int valueToSearch = n[index];
                int foundTimes = 0;

                for(int secondIndex = 0; secondIndex < n.length; secondIndex++){
                    if(n[secondIndex] == valueToSearch) foundTimes++;
                }

                if(foundTimes != 3) return 0;
            }

            return 1;
        }
    }

