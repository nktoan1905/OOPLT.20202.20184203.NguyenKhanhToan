package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.DiscSwap;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("Geogre Lucas");
        dvd2.setLength(124);
        DiscSwap cw1 = new DiscSwap(dvd1);
        DiscSwap cw2 = new DiscSwap(dvd2);
        DigitalVideoDisc.swap(cw1, cw2);
        System.out.println(cw1.c.toString());
        System.out.println(cw2.c.toString());

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
