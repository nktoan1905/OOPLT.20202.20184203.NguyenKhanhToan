package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
    public static void main(String[] args) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("abc pow", "test5","The Lion King", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("def", "test6","Star Wars", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("mnp", "test7","Hello world", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("awm", "test1", "test1", 123, 15.5f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("xyz", "test2", "test2", 80, 19.5f);

//        // Create order
////        Order anOrder = Order.getOrder();
////        assert anOrder != null;
////        anOrder.addDisc(dvd1, dvd2, dvd3, dvd4, dvd5);
//
////		anOrder.check();
//        System.out.println("=========================================");
//        // total cost before get luck
//        System.out.printf("Tong tien truoc khi giam gia: %f %n", anOrder.totalCost());
//        anOrder.getALuckyItem();
//        System.out.printf("Tong tien sau khi giam gia: %f %n", anOrder.totalCost());
////		sc.close();



    }
}
