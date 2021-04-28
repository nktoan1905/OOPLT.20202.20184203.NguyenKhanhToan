package hust.soict.hedspi.aims.media;

import java.util.*;

public class Book extends Media{
    private List<String> authors = new ArrayList<>();
    private String content;
    private List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new TreeMap<>();

    public Book(){}
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
            System.out.println("Danh sách tác giả trống!");
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }
    public void processContent() {

        contentTokens.addAll(Arrays.asList(this.content.split("\\s+")));
        Iterator iterator = contentTokens.iterator();
//        while(iterator.hasNext()){
//            System.out.println((String)iterator.next());
//        }
        Collections.sort(contentTokens);
        for (String string : contentTokens)
            if (wordFrequency.containsKey(string)) {
                int a = wordFrequency.get(string);
                a++;
                wordFrequency.put(string, a);
            } else {
                wordFrequency.put(string, 1);
            }

    }
    public List<String> getAuthors() {
        return authors;
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
            System.out.println("Không thể thêm author vì đã tồn tại!");

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
            System.out.println("không tìm thấy author có name " + authorName);
    }
    @Override
    public String toString() {
        System.out.println("---------Book Information-----------");
        System.out.println("- Title: " + this.getTitle());
        System.out.println("- Catogory: " + this.getCategory());
        System.out.println("- Cost: " + this.getCost());
        System.out.println("- Author: " + this.getAuthors());
        System.out.println("- Content: " + this.content);
        System.out.println("- Content Length: " + this.contentTokens.size());
        System.out.println("- Content Token in sorted order: " + this.contentTokens);
        System.out.println("- Token List & Frequency: ");
        wordFrequency.forEach((key, value) -> System.out.println("\t" + key + ": \t" + value));
        System.out.println("------------------------------------");
        return content;
    }

}