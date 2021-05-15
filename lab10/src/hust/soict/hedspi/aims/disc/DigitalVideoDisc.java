package hust.soict.hedspi.aims.disc;


import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc() {
    }

    public DigitalVideoDisc(int id, String title, String director, int length){
        super(id,title, director, length);
    }

    public DigitalVideoDisc(int id,String title,String category, String director, int length){
        super(id,title, category,director,length);
    }

    public DigitalVideoDisc(int id,String title,String category,float cost, String director, int length){
        super(id,title,category,cost,director,length);
    }

    @Override
    public String toString(){
        return "DVD - "+super.getTitle()+" - "+super.getCategory()+" - "+this.getDirector()+" - "+this.getLength()+" : "+super.getCost()+" $";
    }

    public boolean search (String title){
        String[] token_search = title.toLowerCase().split(" ");
        String[] token_title = title.toLowerCase().split(" ");
        int flag = 0;
        for (String tokenSearch : token_search) {
            for (String s : token_title) {
                if (tokenSearch.equals(s)) {
                    flag++;
                    break;
                }
            }
        }
        return flag == token_search.length;
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}