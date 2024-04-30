package Question1;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            Document doc = new Document();
            doc.addCharacter('H', "Arial", "Red", 12);
            doc.addCharacter('e', "Calibri", "Blue", 14);
            doc.addCharacter('l', "Verdana", "Black", 16);
            doc.addCharacter('l', "Arial", "Red", 12);
            doc.addCharacter('o', "Calibri", "Blue", 14);
            doc.addCharacter('W', "Verdana", "Black", 16);
            doc.addCharacter('o', "Arial", "Red", 12);
            doc.addCharacter('r', "Calibri", "Blue", 14);
            doc.addCharacter('l', "Verdana", "Black", 16);
            doc.addCharacter('d', "Arial", "Red", 12);
            doc.addCharacter('C', "Calibri", "Blue", 14);
            doc.addCharacter('S', "Verdana", "Black", 16);
            doc.addCharacter('5', "Arial", "Red", 12);
            doc.addCharacter('8', "Calibri", "Blue", 14);
            doc.addCharacter('0', "Verdana", "Black", 16);
            doc.addCharacter('0', "Arial", "Red", 12);

            // Edit a character with different properties
            doc.editCharacter(2, 'l', "Calibri", "Green", 18);

            System.out.println("Document content after edit: " + doc.getContent());

            // Save + load the document
            String filename = "HelloWorldCS5800.txt";
            doc.save(filename);

            Document newDoc = new Document();
            newDoc.load(filename);
            System.out.println("Loaded document content: " + newDoc.getContent());
        } catch (IOException e) {
            System.err.println("Error managing document: " + e.getMessage());
        }
    }
}