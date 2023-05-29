public class IsSmart {
    public static void main(String[] args) {
        System.out.println(new TesteIsSmart().execute(16));
    }
}

class TesteIsSmart {
    public int execute(int a) {
        int smartNumber = 1;
        int incrementor = 0;
        int auxNumber = 1;

        while(smartNumber < a){
            if(auxNumber - smartNumber  == incrementor){
                smartNumber = auxNumber;
                incrementor++;
            }

            auxNumber++;
        }

        if(smartNumber == a) return 1;

        return 0;
    }
}
