package lab03;

public class Order {
    public static final int MAX_NUMBERS_ORDER = 10;
    private DigitalVideoDisc itemsOrder[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
    private int qtyOrder = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        // Thêm đĩa vào danh sách
        // Kiểm tra số lượng hiện tại để xem đĩa đầy chưa
        // The disc has been added
        // The order is almost full
        if (qtyOrder < MAX_NUMBERS_ORDER) {
            this.itemsOrder[this.qtyOrder++] = new DigitalVideoDisc(disc.getTitle(), disc.getCategory(),
                    disc.getDirector(), disc.getLength(), disc.getCost());
            System.out.println("The disc has been added");
        } else {
            System.out.println("The order is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        // xóa đĩa được truyền vào
        // Hiện tại cho phép tìm đĩa theo tên, tên trùng nhau là xóa, nếu có nhiều hơn 1 đĩa
        // trùng nhau thì xóa phần tử đầu tiên tìm thấy
        //
        int i, viTri = -1;

        for (i = 0; i < this.qtyOrder; i++) {
            if (this.itemsOrder[i].getTitle().equals(disc.getTitle())) {
                viTri = i;
                break;
            }
        }
        if(viTri == -1) {
            System.out.println("Not found disc in Orders");
        }else {
            for (int j = viTri; j <= this.qtyOrder - 2; j++) {
                 this.itemsOrder[j] = new DigitalVideoDisc(this.itemsOrder[j+1].getTitle());
                this.itemsOrder[j].setCategory(this.itemsOrder[j+1].getCategory());
                this.itemsOrder[j].setCost(this.itemsOrder[j+1].getCost());
                this.itemsOrder[j].setDirector(this.itemsOrder[j+1].getDirector());
                this.itemsOrder[j].setLength(this.itemsOrder[j+1].getLength());
            }
            this.qtyOrder--;
            System.out.println("Remove Success!!");
        }
    }

    public double totalCost() {
        double cost = 0;
        // trả về tổng chi phí của đơn hàng
        for (int i = 0; i < qtyOrder; i++) {
//            System.out.println("disc "+i+" tilte : "+this.itemsOrder[i].getTitle());
            cost += this.itemsOrder[i].getCost();
        }
        return cost;
    }


}
