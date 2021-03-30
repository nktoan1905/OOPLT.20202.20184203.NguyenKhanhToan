package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {
    public static void main(String[] args) throws FileNotFoundException {
        String url = "src\\hust\\soict\\hedspi\\garbage\\file.txt";
        File x = new File(url);
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(x);
        StringBuffer content = new StringBuffer();
        while (sc.hasNextLine()) {
            content.append(sc.nextLine() + "\n");
        }

        System.out.printf("Thoi gian xu ly: %d", System.currentTimeMillis() - start);

        sc.close();

    }
}
