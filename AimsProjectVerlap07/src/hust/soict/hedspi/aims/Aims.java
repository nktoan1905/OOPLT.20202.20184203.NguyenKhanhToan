package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;


public class Aims {
    public static void main(String[] args) {
        int case1 = 0;
        Order anOrder = null;
        while (true) {
            showMenu();
            String line = new Scanner(System.in).nextLine();
            switch (line) {
                case "1" -> {
                    anOrder = new Order();
                    System.out.println("Tạo thành công!!!");
                    case1 = 1;
                }
                case "2" -> {
                    if (case1 == 0) {
                        System.err.println("Xin hãy tạo order trước khi đặt hàng ");
                        break;
                    }
                    showMenuMedia();
                    String type = new Scanner(System.in).nextLine();
                    switch (type) {
                        case "1" -> addBookToOrder(anOrder);
                        case "2" -> addDvdToOrder(anOrder);
                        case "3" -> addCdToOrder(anOrder);
                        case "0" -> System.out.println("Exit submenu!");
                        default -> System.out.println("Syntax error !. Exit submenu!");
                    }
                }
                case "3" -> {
                    if (case1 == 0) {
                        System.err.println("The Media list is empty !");
                        break;
                    }
                    System.out.println("Nhập vào id muốn xóa ");
                    int id = Integer.parseInt(new Scanner(System.in).nextLine());
                    if (anOrder.searchById(id) == null)
                        System.out.println("Id not found !");
                    else {
                        anOrder.removeMedia(id);
                        System.out.println("Deleted !");
                    }
                }
                case "4" -> {
                    if (case1 == 0) {
                        System.err.println("The Media list is empty !");
                        break;
                    }
                    System.out.println("The items list of order");
                    anOrder.display();
                }
                case "0" -> {
                    new Scanner(System.in).close();
                    System.out.println("Quit!");
                    return;
                }
                default -> System.err.println("Syntax error!Please enter again!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("Order Management Application");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }

    public static void showMenuMedia() {
        System.out.println("Select Book or DVD:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private static void addDvdToOrder(Order anOrder) {
        int id;
        do {
            System.out.print("Enter id: ");
            id = Integer.parseInt(new Scanner(System.in).nextLine());
            if (anOrder.searchById(id) != null) {
                System.out.println("Media đã có " + id + " xin vui lòng  ");
            }
        } while (anOrder.searchById(id) != null);
        System.out.print("Enter title: ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("Enter category: ");
        String category = new Scanner(System.in).nextLine();
        System.out.print("Enter director: ");
        String director = new Scanner(System.in).nextLine();
        System.out.print("Enter cost: ");
        float cost = new Scanner(System.in).nextFloat();
        System.out.print("Enter length: ");
        int length = new Scanner(System.in).nextInt();
        new Scanner(System.in).nextLine();
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, director, length);
        String choice;
        do {
            System.out.print("Bạn có muốn nghe thử (yes|no): ");
            choice = new Scanner(System.in).nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                dvd.play();
            } else {
                System.err.println("Syntax error");
            }
        } while (!choice.equalsIgnoreCase("NO") || choice.equalsIgnoreCase("No"));
        anOrder.addMedia(dvd);
    }

    private static void addCdToOrder(Order anOrder) {
        int id;
        do {
            System.out.print("Enter id: ");
            id = Integer.parseInt(new Scanner(System.in).nextLine());
            if (anOrder.searchById(id) != null) {
                System.out.println("Media đã có id: " + id + " xin vui lòng nhập id khác");
            }
        } while (anOrder.searchById(id) != null);
        System.out.print("Enter title: ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("Enter category: ");
        String category = new Scanner(System.in).nextLine();
        System.out.print("Enter artist: ");
        String artist = new Scanner(System.in).nextLine();
        System.out.print("Enter cost: ");
        float cost = new Scanner(System.in).nextFloat();
        new Scanner(System.in).nextLine();
        System.out.print("Enter numbers of list Track: ");
        int count = new Scanner(System.in).nextInt();
        while (count <= 0) {
            System.err.println("số lượng author >= 0. Hãy nhập lại");
            System.out.print("nter numbers of list Track:  ");
            count = new Scanner(System.in).nextInt();
        }
        new Scanner(System.in).nextLine();
        CompactDisc cd = new CompactDisc(id, title, category, cost, artist);
        Track track;
        String titleTrack;
        int lengthTrack;
        for (int i = 0; i < count; i++) {
            System.out.println("Track " + (i + 1));
            System.out.print("Enter title of track: ");
            titleTrack = new Scanner(System.in).nextLine();
            System.out.print("Enter length track: ");
            lengthTrack = new Scanner(System.in).nextInt();
            track = new Track(titleTrack, lengthTrack);
            cd.addTrack(track);
            new Scanner(System.in).nextLine();
        }
        String choice;
        do {
            System.out.print("Bạn có muốn chạy (yes|no): ");
            choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "yes":
                    cd.play();
                    break;
                case "no":
                    break;
                default:
                    System.err.println("Syntax error!");
            }
        } while (choice.equals("no"));
        anOrder.addMedia(cd);
    }

    private static void addBookToOrder(Order anOrder) {
        int id;
        do {
            System.out.print("Enter id: ");
            id = Integer.parseInt(new Scanner(System.in).nextLine());
            if (anOrder.searchById(id) != null) {
                System.out.println("Media có id: " + id + "đã tồn tại. Xin vui lòng nhập lại");
            }
        } while (anOrder.searchById(id) != null);
        System.out.print("Enter title: ");
        String title = new Scanner(System.in).nextLine();
        System.out.print("Enter category: ");
        String category = new Scanner(System.in).nextLine();
        System.out.print("Enter cost: ");
        float cost = Float.parseFloat(new Scanner(System.in).nextLine());
        Book book = new Book(id, title, category, cost);
        int numbersOfAuthors;
        do {
            System.out.print("Enter numbers of authors: ");
            numbersOfAuthors = Integer.parseInt(new Scanner(System.in).nextLine());
            if (numbersOfAuthors <= 0)
                System.err.println("Số lượng author phải >= 0. Nhập lại");
        } while (numbersOfAuthors <= 0);
        for (int i = 0; i < numbersOfAuthors; i++) {
            System.out.print("Enter author's name: ");
            String author = new Scanner(System.in).nextLine();
            book.addAuthor(author);
        }
        anOrder.addMedia(book);
    }
}