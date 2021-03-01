import java.util.Scanner;

public class CalculateTwoDoubleNumbers {
    public static void main(String[] args) {
        Double num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số thứ nhất: ");
        num1 = sc.nextDouble();
        System.out.println("Nhập vào số thứ hai: ");
        num2 = sc.nextDouble();
        System.out.println("Phép cộng: " + num1 + " + " + num2 +" = " +(num1+num2));
        System.out.println("Phép trừ: " + num1 + " - " + num2 +" = " +(num1-num2));
        System.out.println("Phép nhân: " + num1 + " * " + num2 +"=" +(num1*num2));

        if(num2 != 0){
            System.out.println("Phép nhân: " + num1 + " / " + num2 +" = " +(num1/num2));
        }else {
            System.out.println("Phép nhân: không tính được!!!");
        }

    }
}
