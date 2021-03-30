import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;


public class Aims {
    public static void main(String[] args) {
        Order anOrder = new Order();
        DigitalVideoDisc disc1 = new DigitalVideoDisc("The Lion King");
        disc1.setCategory("Animation");
        disc1.setCost(19.95f);
        disc1.setDirector("Roger Allers");
        disc1.setLength(87);

        anOrder.addDigitalVideoDisc(disc1);
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Star Wars");
        disc2.setCategory("Science Fiction");
        disc2.setCost(24.95f);
        disc2.setDirector("George Lucas");
        disc2.setLength(124);
        anOrder.addDigitalVideoDisc(disc2);

        DigitalVideoDisc disc3 = new DigitalVideoDisc("Aladdin");
        disc3.setCategory("Animation");
        disc3.setCost(18.99f);
        disc3.setDirector("Jhon Musker");
        disc3.setLength(90);
        System.out.println(disc2.search("star"));
        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.removeDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);
//        anOrder.addDigitalVideoDisc(disc3);

        System.out.println("Total cost is:");
        System.out.println(anOrder.totalCost());



    }

}
