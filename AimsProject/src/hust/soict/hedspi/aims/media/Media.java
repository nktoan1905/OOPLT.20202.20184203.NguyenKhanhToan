package hust.soict.hedspi.aims.media;

public class Media {
    private String title;
    private String category;
    private float cost;
    private int id;

    public Media(){};


    public Media(int id, String title){
        this.id = id;
        this.title = title;
    }
    public Media(int id,String title,String category){
        this.id = id;
        this.title = title;
        this.category = category;
    }
    public Media(int id,String title,String category,float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}