import java.util.Scanner;

public class PhuongTrinhHaiAn {
    public static void main(String[] args) {
        double a, b, c, a1, b1, c1;
        double d, d1, d2;

        System.out.println("Nhập vào 6 số để giải phương trình hai ẩn:");
        System.out.println("a x + b y = 0");
        System.out.println("a1x + b1y = 0");
        System.out.println("Input a: ");
        a = new Scanner(System.in).nextDouble();
        System.out.println("Input b: ");
        b = new Scanner(System.in).nextDouble();
        System.out.println("Input c: ");
        c = new Scanner(System.in).nextDouble();
        System.out.println("Input a1: ");
        a1 = new Scanner(System.in).nextDouble();
        System.out.println("Input b1: ");
        b1 = new Scanner(System.in).nextDouble();
        System.out.println("Input c1: ");
        c1 = new Scanner(System.in).nextDouble();
        d = a * b1 - a1 * b;
        d1 = c * b1 - c1 * b;
        d2 = a * c1 - a1 * c;
        if (d != 0) {
            double e = d1 / d;
            double e1 = d2 / d;
            System.out.println("Phương trình có một nghiệm x = " + e + " y = " + e1);
        } else if ((d == 0 && d1 != 0) || (d == 0 && d2 != 0)) {
            System.out.println("Phương trình vô nghiệm");
        } else if (d == 0 && d1 == 0 && d2 == 0) {
            System.out.println("Phương trình có vô số nghiệm");
        }

    }

}
