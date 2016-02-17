/**
 * Main program to run cutthroat kitchen game.
 *
 * @author Steven Chen schen107, Jeffrey Chang jchang88
 * 600.226.02
 * Assignment p1
 */

public class CutthroatKitchen {
    import java.util.Scanner;
    import java.io.FileREader;
    import java.io.IOException;
    import java.util.ArrayIndexOutOfBoundsException;
    import java.util.StringTokenizer;

    private int penalties = 0;
    CList<CookingStation> game = new CList<CookingStation>();
    
    

    public static void main(String[] args) throw IOException {
        Scanner kb = new Scanner(System.in);
        String fileName = "game1.txt";
        Scanner inFile = new Scanner(new FileReader(fileName));
        while (inFile.hasNextLine()) {
            String fileLine = inFile.nextLine();
            StringTokenizer st = new StringTokenizer(fileLine, " ");
            String 
        }
        inFile.close();
    }

}
