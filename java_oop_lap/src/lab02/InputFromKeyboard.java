package lab02;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        System.out.println("What's your name?");
        String strName = new Scanner(System.in).nextLine();
        System.out.println("How old are you?");
        int iAge = new Scanner(System.in).nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = new Scanner(System.in).nextDouble();
        System.out.println("Mrs/Ms. " + strName +", "+iAge+" years old. "+"Your height is "+dHeight+"m");
    }
}
