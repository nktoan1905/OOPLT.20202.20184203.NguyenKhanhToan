package hust.soict.hedspi.aims.disc;

public class Track implements Playable {
    private String title;
    int length;

    public Track(String title) {
        this.title = title;
    }

    public Track(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public void play() {
        System.out.println(" Playing Track: " + this.getTitle());
        System.out.println(" DVD Track: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else{
            Track other = (Track) obj;
            return (title.equalsIgnoreCase(other.getTitle()) && length == other.getLength());
        }
    }
    public int compareTo(Track track) {
        if(this.title.compareToIgnoreCase(track.title) < 0)
            return -1;
        else if(this.title.compareToIgnoreCase(track.title) == 0)
            return 0;
        else return 1;
    }
}