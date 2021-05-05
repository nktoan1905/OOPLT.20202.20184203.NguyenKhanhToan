package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public abstract class Media {
    private String title;
    private String category;
    private float cost;
    private int id;

    public Media(){}


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

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else {
            Media media = (Media) obj;
            return id == media.getId();
        }
    }
    public int compareTo(Media media) {
        if (this instanceof Book && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            return -1;
        }
        if(this instanceof DigitalVideoDisc && media instanceof CompactDisc)
            return -1;
        if(this instanceof CompactDisc && (media instanceof DigitalVideoDisc || media instanceof Book))
            return 1;
        if(this instanceof DigitalVideoDisc && media instanceof Book)
            return 1;
        return 0;
    }
    public boolean search(String str) {
        String[] terms = str.split("\\s+");
        for (String term : terms) {
            if (this.title.toUpperCase().indexOf(term.toUpperCase()) == -1) {
                return false;
            }
        }
        return true;
    }
}