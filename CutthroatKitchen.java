/**
 * Main program to run cutthroat kitchen game.
 *
 * @author Steven Chen schen107, Jeffrey Chang jchang88
 * 600.226.02
 * Assignment p1
 */
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
// import java.util.ArrayIndexOutOfBoundsException;

public class CutthroatKitchen {
    
    /**
     * Main method that executes the game.
     * @param args the argument
     */
    public static void main(String[] args) throws IOException {
        //keeps track of the accumulation of penalty points
        int penalties = 0;
        CList<CookingStation> game = new CList<CookingStation>();

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
            CookingStation tempStation = new CookingStation(name);
            line = infile.nextLine();
            while (!line.equals("")) {
                inline = new Scanner(line);
                item = inline.next();
                time = inline.nextInt();
                under = inline.nextInt();
                over = inline.nextInt();
                CookingItem tempItem = new CookingItem(item, time, under, over);
                tempStation.addItem(tempItem);
                //name += " " + item + " " + time + " " + under + " " + over;
                line = infile.nextLine();
            }
            game.append(tempStation);
            //System.out.println(name);
        }
        
        while (game.length() != 0) {
        //for (int x = 0; x < 50; x++) { 
            // Save current position
            int pos = game.currPos();

            // Making string to output
            String kitchen = "[ ";
            game.moveToStart();
            for (int i = 0; i < game.length(); i++) {
                kitchen += game.getValue().getNameS() + " [";
                game.getValue().moveToStart();
                for (int j = 0; j < game.getValue().length(); j++) {
                    kitchen += " (" + game.getValue().getValue().getNameI() 
                             + " " + game.getValue().getValue().timeRemaining()
                             + ")";
                    game.getValue().cycle();
                }
                kitchen += " ] ";
                game.cycle();
            }
            kitchen += "]\n";

            // Print kitchen string
            // TODO: print to output file
            System.out.print(kitchen);
            
            
            // tend current item at current station and cycle
            game.moveToPos(pos);
            System.out.print(game.currPos());
            game.getValue().tend(2, 1000);
            game.getValue().cycle();
            game.cycle();

            if (game.getValue().length() == 0) {
                game.remove();
            }

            // tick every station
            for (int i = 0; i < game.length(); i++) {
                game.getValue().tick();
                game.cycle();
            }
            

        }
    }
}

