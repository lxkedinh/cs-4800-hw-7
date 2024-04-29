package flyweight;

import java.awt.*;
import java.io.File;

public class Driver {
    public static void main(String[] args) {
        // 4 different variations of character properties
        String bigBlackArial = "arial-black-16";
        String mediumRedArial = "arial-red-14";
        String smallblueCalibri = "calibri-blue-12";
        String bigRedVerdana = "verdana-red-16";

        Document doc = new Document();

        // Write "HelloWorldCS5800" with 4 variations in character properties
        doc.write('H', bigBlackArial);
        doc.write('e', bigBlackArial);
        doc.write('l', bigRedVerdana);
        doc.write('l', bigRedVerdana);
        doc.write('o', bigRedVerdana);
        doc.write('W', mediumRedArial);
        doc.write('o', mediumRedArial);
        doc.write('r', smallblueCalibri);
        doc.write('l', smallblueCalibri);
        doc.write('d', bigRedVerdana);
        doc.write('C', bigBlackArial);
        doc.write('S', bigRedVerdana);
        doc.write('5', mediumRedArial);
        doc.write('8', mediumRedArial);
        doc.write('0', smallblueCalibri);
        doc.write('0', smallblueCalibri);
        doc.undo();
        doc.undo();
        doc.write('0', bigBlackArial);
        doc.write('0', mediumRedArial);

        // Save to file on disk
        try {
            doc.saveToFile("helloworld.txt");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Load from file on disk
        Document loadedDoc = new Document("helloworld.txt");
        System.out.println(loadedDoc);
    }
}
