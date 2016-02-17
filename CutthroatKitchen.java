/**
 * Main program to run cutthroat kitchen game.
 *
 * @author Steven Chen schen107, Jeffrey Chang jchang88
 * 600.226.02
 * Assignment p1
 */

public class CutthroatKitchen {
    //imports the scanner
    import java.util.Scanner;
    //imports the file reader
    import java.io.FileREader;
    //imports IOExceptions
    import java.io.IOException;
    //imports the file printer
    import java.io.PrintWriter;
    // imports file writer
    import java.io.FileWriter;
    //imports array index out of bounds exception
    import java.util.ArrayIndexOutOfBoundsException;
    //imports string tokenizer
    import java.util.StringTokenizer;

    //keeps track of the accumulation of penalty points
    private int penalties = 0;
    CList<CookingStation> game = new CList<CookingStation>();
    
    /**
     * Main method that executes the game.
     * @param args the argument
     */
    public static void main(String[] args) throw IOException {
        Scanner kb = new Scanner(System.in);
        String fileName = "game1.txt";
        Scanner inFile = new Scanner(new FileReader(fileName));
        PrintWriter outFile = new PrintWriter(new FileWriter("sim0.txt");
        while (inFile.hasNextLine()) {
            String fileLine = inFile.nextLine();
            StringTokenizer st = new StringTokenizer(fileLine, " ");
            String 
        }
        inFile.close();
    }

}
