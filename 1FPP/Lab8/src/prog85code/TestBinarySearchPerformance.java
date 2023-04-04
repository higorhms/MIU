package prog85code;

import java.util.Arrays;

public class TestBinarySearchPerformance {
    static void sort(char[] c){
        for(int i = 0; i < c.length ; i++){
            for(int j = i; j < c.length; j++){
                if(c[j] < c[i]){
                    char aux = c[i];
                    c[i] = c[j];
                    c[j] = aux;
                }
            }
        }
    }

    // My first attempt
//    static char binarySearch(char[]c, char toFind){
//        char[] aux = c;
//
//        while(aux.length != 0){
//            int middle = aux.length / 2;
//            if(aux[middle] == toFind) return aux[middle];
//            char[] auxiliar = new char[middle];
//            if(aux[middle] > toFind){
//                System.arraycopy(aux, 0, auxiliar, 0, middle);
//            }else{
//                System.arraycopy(aux, middle + 1, auxiliar, 0, middle);
//            }
//            aux = auxiliar;
//        }return 'N';
//    }

    static char binarySearch(char[]c, char toFind){
        int low = 0;
        int high = c.length - 1;

        while(low <= high){
            int middle = low + (high - low) / 2;

            if(c[middle] == toFind) return c[middle];

            if(c[middle] > toFind){
               high = middle + 1;
            }else{
                low = middle - 1;
            }
        }

        return 'N';
    }


    static char normalSearch(char[]c, char toFind){
        for(int i = 0; i < c.length; i++){
            if(c[i] == toFind) return c[i];
        }

        return 'N';
    }

    public static void main(String[] args) {
//        char[] allChars = new char[Character.MAX_VALUE];
//        int count = 0;
//        for (char c = 0; c < Character.MAX_VALUE; c++) {
//            if (Character.isValidCodePoint(c)) {
//                allChars[count++] = c;
//            }
//        }

//        System.out.println("\nTotal of elements to be compared: " + allChars.length);
//        char toFind = 50000; // char number
//
//        long startTime = System.currentTimeMillis();
//        System.out.println("Searching: " + TestBinarySearchPerformance.binarySearch(allChars, toFind));
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//        System.out.println("Execution time using Binary Search: " + totalTime + " milliseconds");
//
//        long secondStartTime = System.currentTimeMillis();
//        System.out.println("Searching: " + TestBinarySearchPerformance.normalSearch(allChars, toFind));
//        long secondEndTime = System.currentTimeMillis();
//        long secondTotalTime = secondEndTime - secondStartTime;
//        System.out.println("Execution time using Find: " + secondTotalTime + " milliseconds");


        int[] allChars = new int[500000];

        for(int i=0; i<500000; i++){
            allChars[i] = i;
        }

        System.out.println("\nTotal of elements to be compared: " + allChars.length);
        int toFind = 489000; // char number

        long startTime = System.currentTimeMillis();
        System.out.println("Searching: " + TestBinarySearchPerformance.binarySearch(allChars, toFind));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Execution time using Binary Search: " + totalTime + " milliseconds");

        long secondStartTime = System.currentTimeMillis();
        System.out.println("Searching: " + TestBinarySearchPerformance.normalSearch(allChars, toFind));
        long secondEndTime = System.currentTimeMillis();
        long secondTotalTime = secondEndTime - secondStartTime;
        System.out.println("Execution time using Find: " + secondTotalTime + " milliseconds");


    }


    static int binarySearch(int[]c, int toFind){
        int low = 0;
        int high = c.length - 1;

        while(low <= high){
            int middle = low + (high - low) / 2;

            if(c[middle] == toFind) return c[middle];

            if(c[middle] > toFind){
                high = middle + 1;
            }else{
                low = middle - 1;
            }
        }

        return 0;
    }

    static int normalSearch(int[]c, int toFind){
        for(int i = 0; i < c.length; i++){
            if(c[i] == toFind) return c[i];
        }

        return 0;
    }
}
