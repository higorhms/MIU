public class IsAscendingFPP {

    public static void main(String[] args) {
        int input = -1245;

        System.out.println(isAscending(input));
    }

    static int isAscending(int input) {
        int lastNumber = 0;
        int auxNumber = input;

        if(input>0){
            while(auxNumber > 0){
                lastNumber = auxNumber % 10;
                auxNumber = auxNumber / 10;

                if(auxNumber % 10 > lastNumber) return 0;
            }
        }

        if(input < 0){
            while(auxNumber < 0){
                lastNumber = auxNumber % 10;
                auxNumber = auxNumber / 10;

                if(auxNumber % 10 < lastNumber) return 0;
            }
        }

        return 1;
    }
}

