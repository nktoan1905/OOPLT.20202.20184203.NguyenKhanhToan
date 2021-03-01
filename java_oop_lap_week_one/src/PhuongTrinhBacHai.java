import java.util.Scanner;

public class PhuongTrinhBacHai {
    public static void main(String[] args) {
        double a,b,c;
        double delta;
        System.out.println("Nhập vào ba số a, b, c để giải phương trình bậc hai: ax^2+bx+c=0");
        System.out.println("Input a: ");
        a = new Scanner(System.in).nextDouble();
        System.out.println("Input b: ");
        b = new Scanner(System.in).nextDouble();
        System.out.println("Input c: ");
        c = new Scanner(System.in).nextDouble();
        if(a == 0){
            if(b == 0 && c == 0){
                System.out.println("Phương trình có vô số nghiệm");
            }else  if(b == 0 && c != 0 ){
                System.out.println("Phương trình vô nghiệm");
            }else {
                System.out.println("Phương trình có nghiệm là: " +(-c/b));
            }
        }else {
            delta = Math.pow(b,2) - 4*a*c;
            System.out.println("Delta = "+delta);
            if(delta < 0){
                System.out.println("Phương trình vô nghiệm.");
            }else if(delta > 0){
                double x1 = (-b + Math.sqrt(delta)/(2*a));
                double x2 = (-b - Math.sqrt(delta)/(2*a));
                System.out.println("Phương trình có nghiệm x1 = "+x1);
                System.out.println("Phương trình có nghiệm x2 = "+x2);
            }else {
                double x = (-b/2*a);
                System.out.println("Phương trình có nghiệm kép x =" +x);
            }
        }
    }
}
