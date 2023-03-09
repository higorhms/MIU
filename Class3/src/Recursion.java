public class Recursion {
    public int sumNumberOfElementsInArray(int[] arr, int numberOfElements){
        if(numberOfElements == 0) return 0;

        return sumNumberOfElementsInArray(arr, numberOfElements - 1) + arr[numberOfElements - 1];
    }

    public static void main(String[] args) {
        System.out.println("Running...");

        System.out.println(new Recursion().sumNumberOfElementsInArray(new int[]{1,2,3,4,5,6}, 1));
    }
}
