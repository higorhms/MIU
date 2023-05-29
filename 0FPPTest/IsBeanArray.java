public class IsBeanArray {

    public static void main(String[] args) {
        int[] input = new int[]{2, 10, 11, 3};
        System.out.println(new TesteIsBeanArray().isBean(input));
    }
}

class TesteIsBeanArray {
    public int isBean(int[ ] a) {
        if(a.length < 2) return 0;

        for(int number : a){
            boolean flag = false;

            for(int secondNumber : a){
               if((secondNumber == number + 1 || secondNumber == number -1) && flag == false){
                    flag = true;
               }
            }

            if(flag == false) return 0;
        }

        return 1;
    }
}

