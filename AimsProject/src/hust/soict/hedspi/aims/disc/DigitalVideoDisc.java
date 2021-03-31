package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc() {
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public boolean search(String title){
        String []str = this.title.split(" ");
        for (String a: str
             ) {
            if(a.equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }
    public DigitalVideoDisc(String title) {
        this.title = title;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    public boolean equals(Object obj) {
        if (obj instanceof DigitalVideoDisc) {
            DigitalVideoDisc another = (DigitalVideoDisc) obj;
            if (this.category.equals(another.category) && this.director.equals(another.director) && this.length == another.length && this.cost == another.cost) {
                return true;
            }
        }
        return false;
    }
    public static void swap(DiscSwap cw1,  DiscSwap cw2)
    {
        DigitalVideoDisc temp = cw1.c;
        cw1.c = cw2.c;
        cw2.c = temp;
    }
    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", length=" + length +
                ", cost=" + cost +
                '}';
    }
}
