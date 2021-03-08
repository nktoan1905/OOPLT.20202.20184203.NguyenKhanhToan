package lab02;

import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        int mt1[][] = new int[100][100];
        int mt2[][] = new int[100][100];
        int size;
        System.out.println("nhập vào cỡ ma trận");
        size = new Scanner(System.in).nextInt();
        System.out.println("Nhập ma trận 1");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("mt1["+i+"]["+j+"] = ");
                mt1[i][j] = new Scanner(System.in).nextInt();
            }
        }

        System.out.println("Nhập ma trận 2");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("mt2["+i+"]["+j+"] = ");
                mt2[i][j] = new Scanner(System.in).nextInt();
            }
        }
        System.out.println("Ma trận 1");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ",mt1[i][j]);
            }
            System.out.println();
        }
        System.out.println("Ma trận 2");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ",mt2[i][j]);
            }
            System.out.println();
        }
    }
}
