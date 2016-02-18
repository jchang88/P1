/**
 * Main program to run cutthroat kitchen game.
 *
 * @author Steven Chen schen107, Jeffrey Chang jchang88
 * 600.226.02
 * Assignment P1
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

/** Main driver for cutthroatkitchen simulation. */
public final class P1 {
   
    /** Empty constructor.
     */
    private P1() {
    } 

    /**
     * Main method that executes the game.
     * @param args the argument
     * @throws IOException if an exception is found
     */
    public static void main(String[] args) throws IOException {
        //instance variable for number 0
        final int zero = 0;
        //instance variable for number 1
        final int one = 1;
        //instance variable for number 2
        final int two = 2;
        //instance variable for number 3
        final int three = 3;
        //instance variable for number 4
        final int four = 4;
        //instance variable for number 5
        final int five = 5;

        runSim(args, zero, zero, "sim0.txt");
        runSim(args, one, zero, "sim1.txt");
        runSim(args, two, zero, "sim2.txt");
        // "optimized" simulation thresholds
        runSim(args, zero, three, "simP.txt");
    }
    

    /** Runs the Cutthroat kitchen simulation.
     *  @param args the arguments input into main
     *  @param removeThreshold the removing threshold used
     *  @param penaltyThreshold the penalty threshold used
     *  @param outputFile name of output file
     */
    public static void runSim(String[] args, int removeThreshold, 
            int penaltyThreshold, String outputFile) {

        // circular list of stations
        CList<CookingStation> game = new CList<CookingStation>();
        
        // scan file input and read into game CList
        Scanner infile = null;
        boolean inerror = false;

        try {
            // args[0] should be input filename
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
                line = infile.nextLine();
            }
            game.append(tempStation);
        }

        //keeps track of the accumulation of penalty points
        int penalties = 0;

        // scan file input and read into game CList
        PrintWriter outfile = null;
        boolean outerror = false;

        // move to tail before first tick, so the first tick starts at the head.
        game.moveToEnd();
        String kitchen = "";
        try {
            outfile = new PrintWriter(new FileWriter(outputFile));
        } catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("must give input filename at command line");
            outerror = true;
        } catch (IOException f) {
            System.err.println("can't open that file, try again");
            outerror = true;
        }
        if (outerror) {
            System.err.println("exiting...");
            System.exit(1);
        }

        
        // tick until all stations are done
        while (game.length() != 0) {

            // Remove any empty stations (if a station is removed, it cycles)
            if (game.getValue().length() == 0) {
                game.remove();
            } else {
                // cycle if no station is removed
                game.cycle();
            }

            // Save current station position
            int stationPos = game.currPos();

            // Making string to output and ticking
            kitchen += "[ ";
            game.moveToStart();
            for (int i = 0; i < game.length(); i++) {
                // save current item position
                int itemPos = game.getValue().currPos();
                kitchen += game.getValue().getNameS() + " [";
                game.getValue().moveToStart();
                for (int j = 0; j < game.getValue().length(); j++) {
                    kitchen += " (" + game.getValue().getValue().getNameI() 
                             + " " + game.getValue().getValue().timeRemaining()
                             + ")";
                    game.getValue().cycle();
                }
                kitchen += " ] ";
                game.getValue().moveToPos(itemPos);
                game.getValue().tick();
                game.cycle();
            }
            kitchen += "]\n";
            
            // tend current item at current station
            game.moveToPos(stationPos);
            CookingItem temp = game.getValue().tend(removeThreshold, 
                    penaltyThreshold);

            // only cycle if tend doesn't remove an item
            if (temp != null) {
                penalties += temp.penalty();
            } else {
                game.getValue().cycle();
            }
        }

        outfile.print(kitchen + "Final penalty was: " + penalties + "\n");
        outfile.close();
        infile.close();
    }
}
