package lab02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCalculate {

    public static void main(String[] args) {
        int[] array = new int[1000];
        int i = 0,sum=  0;
        double avg = 0;
        String a;
        String regex = "\\d+";
        do {
            a = new Scanner(System.in).nextLine();
            if(a.matches("\\D++")){
                break;
            }
            array[i++] = Integer.parseInt(a);
        } while (a.matches(regex));
        for (int j = i; j < 1000; j++) {
            array[j] = (int) (Math.random() * 1000) + 0;
        }
        for (int j = 0; j < 1000; j++) {
            sum+=array[j];
        }
        avg = sum/1000;
        Arrays.sort(array);

        for (int b: array
             ) {
            System.out.println(b);
        }
        System.out.println("Sum = "+sum);
        System.out.println("Avg = "+avg);



    }
}
