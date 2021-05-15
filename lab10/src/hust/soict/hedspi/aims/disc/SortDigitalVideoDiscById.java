package hust.soict.hedspi.aims.disc;

import java.util.Comparator;

public class SortDigitalVideoDiscById implements Comparator<DigitalVideoDisc> {
    @Override
    public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        return o1.getId() - o2.getId();
    }
}
