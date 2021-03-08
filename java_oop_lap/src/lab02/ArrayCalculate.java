package lab02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCalculate {
    public static void main(String[] args) {
        int []array = {1789,2035,1899,1456,2013};
        int s = 0, avg = 0;

        System.out.println("Array elements: ");
        for (int a: array){
            System.out.println(a);
        }
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
        System.out.println("Sum: "+ s);
        avg = s/array.length;
        System.out.println("Avg: "+avg);
        System.out.println("Sort: ");
        Arrays.sort(array);
        for (int a: array){
            System.out.println(a);
        }



    }
}
