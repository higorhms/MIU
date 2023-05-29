import java.sql.Array;

public class Programa {

    public static void main(String[] args){
        int[] input = new int[]{10};
        System.out.println(new Teste().teste(input));
    }
}

 class Teste {
    public int teste(int[] args) {
        if(args.length > 1 && args.length % 2 == 0) return 0;
        if(args.length == 0) return 0;
        if(args.length == 1)  return 1;


        int middleIndex = (args.length - 1)/2;

        for(int index=0; index < args.length; index++){
            if(index != middleIndex){
                if(args[index] <= args[middleIndex]){
                    return 0;
                }
            }
        }

        return 1;
    }
}