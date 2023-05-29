public class ReturnOddAndEven {

    public static void main(String[] args){
        int[] input = new int[]{};
        System.out.println(new TesteOddAndEven().execute(input));
    }
}

class TesteOddAndEven {
    public int execute(int[] args) {
       if(args.length == 0) return 0;
       int sumOfOdd = 0;
       int sumOfEven = 0;

       for(int item  : args){
           if(item%2 == 0) sumOfOdd = sumOfOdd+item;
           if(item%2 != 0) sumOfEven = sumOfEven+item;
       }

        return sumOfEven - sumOfOdd;
    }
}
