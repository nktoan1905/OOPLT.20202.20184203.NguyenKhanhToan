package lab02;

import java.util.Scanner;

public class Day {
    public static void main(String[] args) {
        String[] strMonthArray = {"January", "February",
                "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String[] strMonthArray2 = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String month, year = null;
        int check = 0, tmp = 0;

        do {
            System.out.println("Month: ");
            month = new Scanner(System.in).nextLine();
            for (String a : strMonthArray) {
                if (month.equals(a)) {
                    check++;
                    tmp = 1;
                }
            }
            for (String a : strMonthArray2) {
                if (month.equals(a)) {
                    check++;
                }
            }
        } while (check == 0);

        do {
            System.out.println("Year: ");
            year = new Scanner(System.in).nextLine();
        } while (Integer.parseInt(year) < 0);
        System.out.println(month + " " + year);
        switch (month) {
            case "Jan":
            case "Jan.":
            case "January":
                System.out.println("có 31 ngày");
                break;
            case "Feb":
            case "Feb.":
            case "February":
                if (Integer.parseInt(year) % 4 == 0)
                    System.out.println("có 29 ngày");
                else
                    System.out.println("có 28 ngày");
                break;
            case "Mar":
            case "Mar.":
            case "March":
                System.out.println("có 31 ngày");
                break;
            case "Apr":
                case "Apr.":
            case "April":
                System.out.println("có 30 ngày");
                break;
            case "May":
                System.out.println("có 31 ngày");
                break;
            case "June":
                System.out.println("có 30 ngày");
                break;
            case "July":
                System.out.println("có 31 ngày");
                break;
            case "August":
                System.out.println("có 31 ngày");
                break;
            case "September":
                System.out.println("có 30 ngày");
                break;
            case "October":
                System.out.println("có 31 ngày");
                break;
            case "November":
                System.out.println("có 30 ngày");
                break;
            case "December":
                System.out.println("có 31 ngày");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + month);

        }
    }
}
