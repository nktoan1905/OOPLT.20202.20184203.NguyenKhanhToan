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

        Order anOrder = Order.getOrder();
        assert anOrder != null;
        anOrder.addDigitalVideoDiscVerManyItemsInput(dvd1, dvd2, dvd3, dvd4, dvd5);


        System.out.println("=========================================");
        // total cost before get luck
        System.out.printf("Tổng tiền trước khi giảm: %f %n", anOrder.totalCost());
        DigitalVideoDisc dvd = anOrder.getALuckyItem();
        if(dvd != null){
            System.out.println(dvd.toString());
            System.out.printf("Tổng tiền sau khi giảm: %f %n", anOrder.totalCost());
        }else{
            System.out.println("Rất tiếc bạn không được giảm");
        }




    }
}
