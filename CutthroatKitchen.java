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
    import java.io.FileReader;
    //imports IOExceptions
    import java.io.IOException;
    //imports the file printer
    import java.io.PrintWriter;
    // imports file writer
    import java.io.FileWriter;
    //imports array index out of bounds exception
    import java.util.ArrayIndexOutOfBoundsException;

    //keeps track of the accumulation of penalty points
    private int penalties = 0;
    CList<CookingStation> game = new CList<CookingStation>();
    
    /**
     * Main method that executes the game.
     * @param args the argument
     */
    public static void main(String[] args) throw IOException {
        Scanner infile = null;
        boolean inerror = false;

        try {
            System.out.println("0 " + args[0] + " should be input filename");
            infile = new Scanner(new FileReader(args[0]));
        } catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("must give input filename at command line");
            inerror = true;
        } catch (IOException f) {
            System.err.println("can't open that file, try again");
            inerror = true;
        }
        if (inerror) {
            System.err.println("exiting...");
            System.exit(1);
        }
        
        Scanner inline;
        String line;
        String name, item;
        int time, under, over;
        while (infile.hasNext()) {
            name = infile.nextLine();
            line = infile.nextLine();
            while (!line.equals("")) {
                inline = new Scanner(line);
                item = inline.next();
                time = inline.nextInt();
                under = inline.nextInt();
                over = inline.nextInt();
                name += " " + item + " " + time + " " + under + " " + over;
                line = infile.nextLine();
            }
            System.out.println(name);
        }

    }
}

