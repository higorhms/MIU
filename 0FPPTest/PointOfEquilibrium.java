public class PointOfEquilibrium {

    public static void main(String[] args){
        int[] input = new int[]{1, 2, 10, 3, 4};

        int response = new TestePointOfEquilibrium().execute(input);

        System.out.println(response);

    }
}

class TestePointOfEquilibrium {
    public int execute(int[] numbers) {
        if(numbers == null || numbers.length < 2) return -1;

        int poe = -1;
        int sumOfTheInitials = 0;

        for(int index = 0; index < numbers.length; index++){
            int sumOfTheRest = 0;

            for(int index2 = index + 1; index2 < numbers.length; index2++){
                if(index2 > index + 1){
                    sumOfTheRest = sumOfTheRest + numbers[index2];
                }
            }

            sumOfTheInitials = sumOfTheInitials + numbers[index];

            if(index > 0) {
                if (sumOfTheRest == sumOfTheInitials) {
                    return index + 1;
                }
            }
        }

       return poe;
    }
}