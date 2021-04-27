package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String artist, List<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String artist, List<Track> tracks) {
        super(id, title);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, String artist, List<Track> tracks) {
        super(id, title, category);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        int flag = 0;
        for (Track o : tracks) {
            if (o.getTitle().equals(track.getTitle()) && o.getLength() == track.getLength()) {
                flag = 1;
                break;
            }
        }
        if (flag == 0)
            tracks.add(track);
        else
            System.out.println("Đã tồn tại track");
    }

    public void removeTrack(Track track) {
        int flag = 0;
        for (Track o : tracks) {
            if (o.getTitle().equals(track.getTitle()) && o.getLength() == track.getLength()) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            tracks.remove(track);
        else
            System.out.println("Không tìm thấy trách");
    }

    public int getLength() {
        int sumLength = 0;
        for (Track o : tracks) {
            sumLength += o.getLength();
        }
        return sumLength;
    }

    public void play() {
        for (Track o : tracks) {
            o.play();
        }
    }

    public String toString() {
        return "CV - " + super.getTitle() + " - " + super.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + " : " + super.getCost() + " $";
    }

}