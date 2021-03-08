package lab01;

import java.util.Scanner;

public class PhuongTrinhBacMot {
    public static void main(String[] args) {
        // ax+b=0;
        double a,b;
        System.out.println("Nhập vào hai số a và b để giải phương trình ax+b=0");
        System.out.println("Input a = ");
        a = new Scanner(System.in).nextDouble();
        System.out.println("Input b = ");
        b = new Scanner(System.in).nextDouble();
        if(a == 0 && b == 0){
            System.out.println("Phương trình có vô số nghiệm");
        }else  if(a == 0 && b != 0 ){
            System.out.println("Phương trình vô nghiệm");
        }else {
            System.out.println("Phương trình "+a+"x + "+b+"= 0 là:" +(-b/a));
        }
    }
}
