package hust.soict.hedspi.aims.order;


import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    private int qtyOrdered = 0;
    private static int nbOrders = 0;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private final MyDate dateOrdered = new MyDate();

    public static Order getOrder() {
        if(nbOrders < MAX_LIMITED_ORDERS) {
            Order newOrder = new Order();
            nbOrders++;
            return newOrder;
        }
        else {
            System.out.println("The numbers of orders is almost max.");
            return null;
        }
    }



    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (this.qtyOrdered  < MAX_NUMBERS_ORDERED) {
            DigitalVideoDisc item = new DigitalVideoDisc(dvd.getTitle(), dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost());
            this.itemsOrdered[this.qtyOrdered] = item;
            this.qtyOrdered++;
            System.out.println("The disc " + dvd.getTitle() + " has been added");
        }
        else System.out.println("The order is almost full");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (this.qtyOrdered  < MAX_NUMBERS_ORDERED) {
            DigitalVideoDisc item1 = new DigitalVideoDisc(dvd1.getTitle(), dvd1.getCategory(), dvd1.getDirector(), dvd1.getLength(), dvd1.getCost());
            DigitalVideoDisc item2 = new DigitalVideoDisc(dvd2.getTitle(), dvd2.getCategory(), dvd2.getDirector(), dvd2.getLength(), dvd2.getCost());
            this.itemsOrdered[this.qtyOrdered++] = item1;
            if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The dvd " +  dvd2.getTitle()+ " could not be added");
            }else {
                this.itemsOrdered[this.qtyOrdered++] = item2;
            }
        }
        else System.out.println("The order is almost full");
    }

    public void addDigitalVideoDiscVerManyItemsInput(DigitalVideoDisc ...dvdList) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The order is almost full");
            return;
        }
        for (DigitalVideoDisc disc: dvdList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered[this.qtyOrdered++] = disc;
                System.out.println("The DVD " + disc.getTitle() + " has been added.");
            }else {
                System.out.println("The order is almost full");
                break;

            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        int k = -1;
        for(int i=0; i < this.qtyOrdered; i++) {
            if(this.itemsOrdered[i].equals(dvd)) {
                for(int j=i;j < this.qtyOrdered - 1; j++) {
                    this.itemsOrdered[j] = new DigitalVideoDisc(this.itemsOrdered[j+1].getTitle(), this.itemsOrdered[j+1].getCategory(), this.itemsOrdered[j+1].getDirector(), this.itemsOrdered[j+1].getLength(), this.itemsOrdered[j+1].getCost());
                }
                this.qtyOrdered--;
                k = i;
                System.out.println("Remove " + dvd.getTitle() + " successfully");
                break;
            }
        }
        if (k == -1) {
            System.out.println("The Disc " +  dvd.getTitle() + " Not found");
        }


    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < this.qtyOrdered; i++) {
            sum += this.itemsOrdered[i].getCost();
        }
        return sum;
    }

    public DigitalVideoDisc getALuckyItem() {
        DigitalVideoDisc disc;
        int lucky = (int) (Math.random() * ((this.qtyOrdered ) - 0 + 1) +0);
        if(lucky > this.qtyOrdered -1){

            return null;
        }else{
            this.itemsOrdered[lucky].setCost(0f);
            disc = new DigitalVideoDisc(this.itemsOrdered[lucky].getTitle(),this.itemsOrdered[lucky].getCategory()
                    ,this.itemsOrdered[lucky].getDirector(), this.itemsOrdered[lucky].getLength(),this.itemsOrdered[lucky].getCost());
            return disc;
        }
    }
    public void printListOfOrdered() {
        System.out.println("********************************THIS IS YOUR ORDER******************************");
        dateOrdered.print();
        System.out.println("Ordered Items: ");
        for(int i=0; i<this.qtyOrdered; i++) {
            System.out.println("DVD - " + this.itemsOrdered[i].getTitle() + " - " + this.itemsOrdered[i].getCategory() + " - " + this.itemsOrdered[i].getDirector() + " - " + this.itemsOrdered[i].getLength() + " : " + this.itemsOrdered[i].getCost());
        }
        System.out.println("Total cost: " + totalCost());

    }
}

