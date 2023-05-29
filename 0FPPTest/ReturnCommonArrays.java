import java.sql.Array;
import java.util.ArrayList;

public class ReturnCommonArrays {



    public static  void main(String[] args){
        int[] firstArray = new int[]{1, 2};
        int[] secondArray = new int[]{1, 2, 3};

        int[] result = new ReturncommonArrayTest().execute(firstArray, secondArray);

        if(result != null){
            for(int r: result){
                System.out.println(r);
            }
        }else{
            System.out.println("null");
        }
    }

}

class ReturncommonArrayTest{
    public int[] execute(int[] first, int[] second){
        if(first == null || second == null ) return null;
        if(first.length == 0 || second.length ==0) return new int[]{};

        ArrayList<Integer> auxiliar = new ArrayList<Integer>();

        for (int firstItem: first) {
           for (int secondItem: second){
               if(firstItem == secondItem) {
                   auxiliar.add(firstItem);
               }
           }
        }

        if(auxiliar.size() == 0) return new int[]{};

        int[] aux = new int[auxiliar.size()];

       for(int index = 0; index < auxiliar.size(); index++){
           aux[index] = auxiliar.get(index);
       }


        return aux;
    }
}