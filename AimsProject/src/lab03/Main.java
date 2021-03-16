package lab03;

public class Main {
    public static void main(String[] args) {
        MyDate myDate = new MyDate("February 29th 2020");
        MyDate myDate1 = new MyDate();
        MyDate myDate2 = new MyDate(3,4,2019);
        MyDate myDate3 = new MyDate();

        myDate.print();
        myDate1.print();
        myDate2.print();
        myDate3.accept();
        myDate3.print();
    }
}
