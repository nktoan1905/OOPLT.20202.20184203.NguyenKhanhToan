package hust.soict.hedspi.aims.utils;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class MyDate {
    private int day;
    private int month;
    private int year;
    private boolean equals;

    public MyDate(){
        this.day = LocalDate.now().getDayOfMonth();
        this.month = LocalDate.now().getMonthValue();
        this.year = LocalDate.now().getYear();
    }
    public MyDate(int day, int month, int year){
        if((day >=1 && day <=getDaysOfMonth(month, year)) && (month >=1 && month <= 12) && (year >= 0)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else{
            if(!(day >=1 && day <=getDaysOfMonth(month,year)))
                System.out.println("Error : Invalid day");
            if(!(month >=1 && month <= 12))
                System.out.println("Error : Invalid month");
            if (year < 0)
                System.out.println("Error : Invalid year");
        }
    }
    public MyDate(String date){
        // date : February 18th 2019 or Feb. 18th 2019 or Feb 18th 2019 or 2 18 2019 (format : mm dd yyyy)
        int [] Date = validDate(date);
        if(Date != null){
            month = Date[0];
            day = Date[1];
            year = Date[2];
        }
    }
    public MyDate(String day, String month, String year){
        int d =0 ,m = 0,y = -1;
        for (int i = 0 ; i < validDay.length ; i++){
            if(day.toLowerCase().equals(validDay[i])) {
                d = i + 1;
                break;
            }
        }
        m = checkValidMonth(month,validMonth);
        y = convertYear(year);
        if((d != 0 && d <= getDaysOfMonth(m,y)) && m != 0 && y !=-1){
            this.day = d;
            this.month = m;
            this.year = y;
        }
        else{
            if(d == 0 || d > getDaysOfMonth(m,y) )
                System.out.println("Error : Invalid day");
            if(m == 0)
                System.out.println("Error : Invalid month");
            if (y < 0)
                System.out.println("Error : Invalid year");
        }
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day >= 1 && day <= getDaysOfMonth(month,year))
            this.day = day;
        else {
            System.out.println("Error: Invalid Day.");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month >=1 && month <=12)
            this.month = month;
        else {
            System.out.println("Error: Invalid Month.");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year >=0 )
            this.year = year;
        else {
            System.out.println("Error: Invalid Year.");
        }
    }

    public String print(){
        String m;
        if(month == 1)
            m = "January";
        else if(month == 2)
            m = "February";
        else if(month == 3)
            m = "March";
        else if(month == 4)
            m = "April";
        else if(month == 5)
            m = "May";
        else if(month == 6)
            m = "June";
        else if(month == 7)
            m = "July";
        else if(month == 8)
            m = "August";
        else if(month == 9)
            m = "September";
        else if(month == 10)
            m = "October";
        else if(month == 11)
            m = "November";
        else
            m = "December";
        String d;
        if(day == 1 || day == 21)
            d = day+"st";
        else if(day == 2 || day == 22)
            d = day+"nd";
        else if(day == 3 || day == 23)
            d = day+"rd";
        else
            d = day+"th";
        return "My Date : "+m+" "+d+" "+year;
    }
    public String print(int option){
        String d = (day>9)?day+"":"0"+day;
        String mm = (month>9)?month+"":"0"+month;
        String MMM = validMonth.get(month-1).substring(0,3);
        switch (option){
            case 1:
                return "My Date (yyyy-MM-dd): "+year+"-"+mm+"-"+d;
            case 2:
                return "My Date (d/M/yyyy): "+day+"/"+month+"/"+year;
            case 3:
                return "My Date (dd-MMM-yyyy): "+d+"-"+MMM+"-"+year;
            case 4:
                return "My Date (MMM d yyyy): "+MMM+" "+day+" "+year;
            case 5:
                return "My Date (mm-dd-yyyy): "+mm+"-"+d+"-"+year;
            default:
                return print();
        }
    }
    public int convertYear(String year){
        String y = year.toLowerCase();
        String[] itemsY = y.split("\\s");
        if(itemsY.length < 2) {
            return -1;
        }
        int num1,num2;
        num1 = cutStringYear(itemsY[0]);
        if(num1 == -1)
            return -1;
        num2 = cutStringYear(itemsY[1]);
        if(num2 == -1 && itemsY[1].equals("hundred"))
            num2 = 0;
        else if(num2 == -1 && !itemsY[1].equals("hundred"))
            return -1;
        return num1*100 + num2;
    }
    public int cutStringYear (String cutItem){
        String[] numType1 = {"one","two","three","four","five","six","seven","eight","nine"};
        String[] numType2 = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] numType3 = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        int num1=0,num2=0;
        int flag = 0;
        if(!cutItem.contains("-")){
            for (int i = 0 ; i < numType1.length ; i++){
                if(numType1[i].equals(cutItem)){
                    num1 = i + 1;
                    num2 = 0 ;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                for (int i = 0 ; i < numType2.length ; i++){
                    if(numType2[i].equals(cutItem)){
                        num1 = 1;
                        num2 = i ;
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                for (int i = 0 ; i < numType3.length ; i++){
                    if(numType3[i].equals(cutItem)){
                        num1 = i + 2;
                        num2 = 0 ;
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0 )
                return -1;
        }
        else{
            String[] itemsArr = cutItem.split("-");
            if (itemsArr.length < 2){
                return -1;
            }

            for (int i = 0 ; i < numType3.length ; i++){
                if(numType3[i].equals(itemsArr[0])){
                    num1 = i + 2;
                    break;
                }
            }
            if(num1 == 0 )
                return -1;
            for (int i = 0 ; i < numType1.length ; i++){
                if(numType1[i].equals(itemsArr[1])){
                    num2 = i + 1;
                    break;
                }
            }
            if(num2 == 0)
                return -1;

        }
        return num1*10 + num2;
    }
    public String toString(){
        return month+" "+day+" "+year;
    }

    public void accept(){
        // date : February 18th 2019 or Feb. 18th 2019 or Feb 18th 2019 or 2 18 2019 (format : mm dd yyyy)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date (format : mm dd yyyy) : ");
        String date = sc.nextLine();
        int [] Date = validDate(date);
        if(Date != null){
            month = Date[0];
            day = Date[1];
            year = Date[2];
        }
    }

    private int[] validDate(String date){
        int error = 0 ;
        String[] itemsD = date.split("\\s");
        if(itemsD.length < 3) {
            System.out.println("Error Invalid date");
            return null;
        }
        String month = itemsD[0], day = itemsD[1], year = itemsD[2];
        int m = checkValidMonth(month,validMonth);
        if(m==0) {
            System.out.println("Syntax of Error ! (Month)");
            error = 1;
        }
        int d = checkValidDay(day) ;
        if(d==0){
            System.out.println("Syntax of Error !(Day) ");
            error = 1;
        }
        int y = 0;
        if(isNumeric(year)) {
            y = Integer.parseInt(year);
            if(y<0)
            {
                System.out.println("Syntax of Error ! (Year)");
                error = 1;
            }
        }
        else{
            System.out.println("Syntax of Error ! (Year)");
            error = 1;
        }
        if(error == 0){
            if(d < getDaysOfMonth(m,y)) {
                int[] Date = {m, d, y};
                return Date;
            }
            else{
                System.out.println("Error Invalid day");
                return null;
            }
        }
        else {
            return null;
        }
    }

    private  List<String> validMonth = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
            "Jan.", "Feb.", "Mar.", "Apr.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.",
            "Jan","Feb","Mar","Apr","Jul","Aug","Aug","Sep","Oct","Nov","Dec"
    );
    private String[] validDay = {"first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth","thirteenth","fourteenth",
            "fifteen","sixteenth","seventeenth","eighteenth","nineteenth","twentieth","twenty-first","twenty-second","twenty-third","twenty-fourth","twenty-fifth","twenty-sixth",
            "twenty-seventh","twenty-eighth","twenty-ninth","thirtieth","thirty-first"};

    private int checkLeapYear(int year){
        if(year%4==0&&!(year%100==0&&year%400!=0))
            return 1;
        return 0;
    }
    private int checkValidMonth(String month,List<String> validMonth){
        if(isNumeric(month)&&Integer.parseInt(month)>=1&&Integer.parseInt(month)<=12)
            return Integer.parseInt(month);
        if(validMonth.stream().filter(o-> o.toLowerCase().equals(month.toLowerCase())).findFirst()!=null){
            String m = month.toLowerCase();
            if(m.equals("january")||m.equals("jan.")||m.equals("jan"))
                return 1;
            else if (m.equals("february")||m.equals("feb.")||m.equals("feb"))
                return 2;
            else if (m.equals("march")||m.equals("mar.")||m.equals("mar"))
                return 3;
            else if (m.equals("april")||m.equals("apr.")||m.equals("apr"))
                return 4;
            else if (m.equals("may"))
                return 5;
            else if (m.equals("june")||m.equals("jun"))
                return 6;
            else if (m.equals("july")||m.equals("jul"))
                return 7;
            else if (m.equals("august")||m.equals("aug.")||m.equals("aug"))
                return 8;
            else if (m.equals("september")||m.equals("sep.")||m.equals("sep"))
                return 9;
            else if (m.equals("october")||m.equals("oct.")||m.equals("oct"))
                return 10;
            else if (m.equals("november")||m.equals("nov.")||m.equals("nov"))
                return 11;
            else if (m.equals("december")||m.equals("dec.")||m.equals("dec"))
                return 12;
        }
        return 0;
    }
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private int checkValidDay(String date){
        int d;
        if(isNumeric(date))
            d =  Integer.parseInt(date);
        else{
            String lod = date.substring(date.length()-2).toLowerCase();
            if(lod.equals("st")||lod.equals("nd")||lod.equals("rd")||lod.equals("th")){
                date = date.substring(0,date.length()-2);
            }
            if(isNumeric(date))
                d =  Integer.parseInt(date);
            else
                return 0;
        }
        if(d>=1 && d <= 31)
            return d;
        else
            return 0;
    }
    private int getDaysOfMonth (int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 2 && checkLeapYear(year) == 1) {
            return 29;
        } else if (month == 2 && checkLeapYear(year) == 0)
            return 28;
        else
            return 30;
    }
}
