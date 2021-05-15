package hust.soict.hedspi.test.book;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book(1,"Hello","Văn học");
        book.addAuthor("Toàn");
        book.addAuthor("Đức");
        book.addAuthor("Minh");
        book.setContent("Lorem ipsum, dolor sit amet consectetur adipisicing elit. Error assumenda omnis, amet facere totam facilis. Ipsam, laboriosam, a veniam veritatis facilis amet doloremque nisi accusamus ut, sequi quidem blanditiis quibusdam.");
        book.toString();
    }
}
