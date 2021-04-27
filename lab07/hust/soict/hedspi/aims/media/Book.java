package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(){};
    public Book(int id,String title){
        super(id,title);
    }
    public Book(int id,String title, String category){
        super(id,title, category);
    }
    public Book(int id,String title, String category, float cost){
        super(id,title, category,cost);
    }
    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        if(authors.size() != 0) {
            this.authors = authors;
        }else {
            System.out.println("Authors list is empty !");
        }
    }
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        int flag = 0;
        for (String o : authors) {
            if(o.equals(authorName)){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            authors.add(authorName);
        else
            System.out.println("Can not add the author's name because it existed !");

    }
    public void removeAuthor(String authorName){
        int flag = 0;
        for (String o : authors) {
            if(o.equals(authorName)){
                flag = 1;
                break;
            }
        }
        if(flag == 1)
            authors.removeIf(o->o.equals(authorName));
        else
            System.out.println("The author's name not found !");
    }
    @Override
    public String toString(){
        return "Book - "+super.getTitle()+" - "+super.getCategory()+" - Author : "+authors.toString()+" - "+super.getCost()+" $";
    }
}
