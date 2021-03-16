package lab03;

import java.time.LocalDate;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;
    // lấy time hiện tại
    public MyDate() {
        LocalDate localDate = LocalDate.now();
        this.day = localDate.getDayOfMonth();
        this.month = localDate.getMonthValue();
        this.year = localDate.getYear();
    }
    // lấy time nhập vào 3 tham số day month, year
    public MyDate(int day, int month, int year) {

        if (month >= 1 && month <= 12 && year >= 0 && day>=1 && day <= getDayOfMonth(month,year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }else{
            if(month <= 0 || month > 12){
                System.out.println("Error Month!!!");
            }
            if(year < 0){
                System.out.println("Error Year!!!");
            }
            if(day<=0 || day > getDayOfMonth(month, year)){
                System.out.println("Error Day!!!");
            }
        }
    }
    // lấy time dụa vào String date
    public MyDate(String strDate) {
        //strDate format dd-mm-yyyy
        int[] Date = checkDate(strDate);
        if(Date != null){
            this.month = Date[0];
            this.day = Date[1];
            this.year = Date[2];
        }
    }

    private int[] checkDate(String strDate) {
        // Tách chuỗi strDate bời khoảng trắng Vd Jan 18th 2019
        int []date = new int[3];
        String[] tmp = strDate.split(" ");
        String day,month,year;

        month = tmp[0];
        day = tmp[1];
        year = tmp[2];
        int m = valueMonth(month),d,y = 0;
        int err = 0;
        if(m == 0){
            System.out.println("Error Month");
            err = 1;
        }
        if(checkStringIsNumber(year)){
            y = Integer.parseInt(year);
            if(y < 0){
                System.out.println("Error Year");
                err = 1;
            }
        }else {
            System.out.println("Error Year");
            err = 1;
        }
        d = valueDay(day);
        if(d == 0){
            System.out.println("Error Day!");
            err = 1;
        }
        if(err == 0){
            if(d <= getDayOfMonth(m,y)){
                date[0] = m;
                date[1] = d;
                date[2] = y;
                return date;
            }else{
                System.out.println("Error Date");
                return null;
            }
        }else return null;
    }

    private int valueMonth(String month) {

        String m = month.toLowerCase();
        if (checkStringIsNumber(month) && Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12) {
            // nếu month là string toàn số và thỏa mãn đk về tháng thì trả về luôn
            return Integer.parseInt(month);
        }

        return switch (m) {
            case "january", "jan.", "jan" -> 1;
            case "february", "feb.", "feb" -> 2;
            case "march", "mar.", "mar" -> 3;
            case "april", "apr.", "apr" -> 4;
            case "may" -> 5;
            case "june", "jun" -> 6;
            case "july", "jul" -> 7;
            case "august", "aug.", "aug" -> 8;
            case "september", "sep.", "sep" -> 9;
            case "october", "oct.", "oct" -> 10;
            case "november", "nov.", "nov" -> 11;
            case "december", "dec.", "dec" -> 12;
            default -> 0;
        };
    }

    private int valueDay(String day) {
        String dayFormat;// tách duôi của ngày

        int tmpDay;
        if (checkStringIsNumber(day)) {
            tmpDay = Integer.parseInt(day);
        } else {
            dayFormat = day.substring(day.length() - 2).toLowerCase(); // nếu đuôi cuối của ngày trùng với các trường hợp format này là đúng
            // Format day : 'st' ,'nd', 'rd', 'th'
            if (dayFormat.equals("st") || dayFormat.equals("nd") || dayFormat.equals("rd") || dayFormat.equals("th")) {
                day = day.substring(0, day.length() - 2);
            }
            if (checkStringIsNumber(day)) {
                tmpDay = Integer.parseInt(day);
            } else {
                return 0;
            }
        }
        if (tmpDay < 0 || tmpDay > 31) {
            return 0;
        } else return tmpDay;
    }

    private int getDayOfMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (year % 4 == 0) {
                    return 29;
                } else return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                System.out.println("Error Month");
                return 0;
        }
    }
    private boolean checkStringIsNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void accept() {
        //format date mm/dd/yyyy
        System.out.println("Enter date:");
        String strDate = new Scanner(System.in).nextLine();
        int []date = checkDate(strDate);
        if(date != null){
            this.month = date[0];
            this.day = date[1];
            this.year = date[2];
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day >= 1 && day <= getDayOfMonth(this.month,this.year))
            this.day = day;
        else {
            System.out.println("Error Day!!!");
        }
    }



    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month >=1 && month <=12)
            this.month = month;
        else {
            System.out.println("Error Month!!");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year >=0 )
            this.year = year;
        else {
            System.out.println("Error Year!!");
        }
    }

    public void print() {
        System.out.println("Date: " + this.month + " - " + this.day + " - " + this.year);
    }
}
