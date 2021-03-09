package lab02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCalculate {

    public static void main(String[] args) {

        int i = 0, sum = 0, size;
        double avg = 0;
        String a;
        String regex = "\\d+";
        System.out.println("Nhập vào số phần tử của mảng");
        size = new Scanner(System.in).nextInt();
        int[] array = new int[size];
        do {
            a = new Scanner(System.in).nextLine();
            if(i>size){
                break;
            }
            if (a.matches("\\D++")) {
                break;
            }
            array[i++] = Integer.parseInt(a);
        } while (a.matches(regex));

        System.out.println("các phần tử nhập vào");
        for (int j = 0; j < i; j++) {
            System.out.println(array[j]);
        }

        for (int j = i; j < size; j++) {
            array[j] = (int) (Math.random() * 1000) + 0;
        }

        for (int j = 0; j < size; j++) {
            sum += array[j];
        }

        avg = sum / size;
        Arrays.sort(array);

        System.out.println("sau khi sắp xếp:");
        for (int j = 0; j < size; j++) {
            System.out.println(array[j]);
        }
        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + avg);


    }
}
