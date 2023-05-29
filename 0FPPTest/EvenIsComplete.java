public class EvenIsComplete {
    public static void main(String[] args) {
        int[] input = new int[]{2, -3, 4, 3, 6};

        System.out.println(new TesteEvenIsComplete().execute(input));
    }
}

class TesteEvenIsComplete {
    public int execute(int[ ] a) {
        int highestEven = 0;

        for(int number : a){
            if(number < 1) return 0;
            if(number % 2 == 0 && number > highestEven) highestEven = number;
        }


        for (int index = highestEven - 2; index > 2; index = index - 2){
            boolean flag = false;

            for(int number : a){
                if(number == index) flag = true;
            }

            if(flag == false) return 0;
        }

        return 1;
    }
}

