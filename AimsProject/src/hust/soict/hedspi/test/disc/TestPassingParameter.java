package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.DiscSwap;

public class TestPassingParameter {
    public static void main(String[] args) {

    }


    public static void swap(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {

            DigitalVideoDisc tmp = dvd1;

//            System.out.println(tmp.toString());

            dvd1.setTitle(dvd2.getTitle());
            dvd1.setCategory(dvd2.getCategory());
            dvd1.setDirector(dvd2.getDirector());
            dvd1.setLength(dvd2.getLength());
            dvd1.setCost(dvd2.getCost());

            dvd2.setTitle(tmp.getTitle());
            dvd2.setCategory(tmp.getCategory());
            dvd2.setDirector(tmp.getDirector());
            dvd2.setLength(tmp.getLength());
            dvd2.setCost(tmp.getCost());

    }
    public static void changeTitle(DigitalVideoDisc dvd, String title){
        dvd.setTitle(title);
    }
}
