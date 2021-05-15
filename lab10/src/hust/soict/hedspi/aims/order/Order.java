package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERS = 5;
    private static int nbOrders = 0;

    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public Order() {
        if (nbOrders < MAX_LIMITED_ORDERS) {
            nbOrders++;
        } else {
            System.out.println("The current number of orders is over this limited number,cannot make any new order.");
        }
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED)
            this.itemsOrdered.add(media);
        else
            System.out.println("The list media is full !");
    }

    public void removeMedia(int id) {
        this.itemsOrdered.removeIf(o -> o.getId() == id);
    }

    public Media searchById(int id) {
        return this.itemsOrdered.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    public float totalCost() {
        float cost = 0;
        for (Media o : itemsOrdered) {
            cost += o.getCost();
        }
        return cost;
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public void display() {
        this.itemsOrdered.forEach(o -> System.out.println(o.toString()));
    }
    public List<Media> search(String term) {
        List<Media> result = new ArrayList<Media>();
        for (Media media : itemsOrdered) {
            if (media.search(term)) {
                result.add(media);
            }
        }
        return result;
    }
    public boolean removeMedia(Media media) {
        try {
            if(itemsOrdered.remove(media)) {
                System.out.println("Media has been deleted.");
                return true;
            }
            else {
                System.out.println("The order does not have that media.");
            }
        }
        catch (Exception e) {
            System.out.println("Error");
        }
        return false;
    }
    public Media getALuckyItem(float requiredTotal, int requiredItem, float luckyRate, float discountRate) {
        if (this.totalCost() < requiredTotal) {
            return null;
        }
        if (this.getItemsOrdered().size() < requiredItem) {
            return null;
        }
        double roll = Math.random();
        if (roll > luckyRate) {
            return null;
        }

        int discountAmount = (int) Math.floor(discountRate*this.totalCost());
        List<Media> validItem = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getCost() <= discountAmount) {
                validItem.add(media);
            }
        }
        if (validItem.size() == 0) {
            return null;
        }
        int i = (int) (validItem.size()* Math.random());
        itemsOrdered.get(itemsOrdered.indexOf(validItem.get(i))).getCost();
        return validItem.get(i);
    }
}