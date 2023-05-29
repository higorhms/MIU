public class IsBulkArrayFPP {
    
    public static void main(String[] args) {
        int[] input = new int[]{10, -2, -3};

        System.out.println(new TesteIsBulkArrayFPP().isBulkArray(input));
    }
}

class TesteIsBulkArrayFPP {
    public int isBulkArray(int[] n) {
        if(n == null || n.length < 2)  return 1;

        for(int index = 0; index < n.length; index++){
            int valueToSearch = n[index] * 2;

            for(int index2 = 0; index2 < n.length;  index2++){
                if(index != index2){
                    if(n[index2] == valueToSearch){
                        return 0;
                    };
                }
            }
        }

       return 1;
    }
}
