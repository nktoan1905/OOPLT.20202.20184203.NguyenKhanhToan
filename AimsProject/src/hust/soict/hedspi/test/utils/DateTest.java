package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
    public static void main(String[] args) throws Exception {
//        MyDate test = new MyDate("Third", "January", "two thousand");
//        test.print();
//        test.printFormat();
        int check = DateUtils.compareDate("31/03/2020", "01/04/2020");
        switch (check) {
            case -1 -> System.out.println("Ngay 1 < 2");
            case 1 -> System.out.println("Ngay 1 > 2");
            case 0 -> System.out.println("2 ngay = ");
        }

        String[] date = {"03/05/2020", "31/12/2014", "01/01/2013"};
        DateUtils.sortingDate(date);
        DateUtils.printDate(date);
    }
    }

