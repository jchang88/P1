/**
 * Cooking station class implementation.
 * Each station is implemented with a circular linked list data structure.
 * Based on the Cooking Station interface provided in the assignment document.
 *
 * @author Joanne Selinski, Steven Chen schen107, Jeffrey Chang jchang88
 * 600.226.02
 * Assignment P1
 */

public class CookingStation extends CList<CookingItem> 
    implements CookingStationInterface {
    
    /** Name of station. */
    private String name;

    /** Constructor to build the cooking station. 
     * @param n the name of the station
     */
    public CookingStation(String n) {
        this.name = n;
    }

    /** Returns the name of the station.
     * @return the name of the station
     */
    public String getNameS() {
        return this.name;
    }

    /** Put a new dish at the end of the station.
     *  @param it the dish to add
     */
    public void addItem(CookingItem it) {
        this.append(it);
    }

    /** Simulate one minute time passing for this station.
     */
    public void tick() {
        for (int i = 0; i < this.length(); i++) {
            this.getValue().tick();
            this.cycle();
        }
    }

    /** Tend the current item.
     *  @param removeThreshold the number of minutes that may be used to 
     *            determine if an item should be removed from the station.
     *  @param penaltyThreshold the limit on the penalty value that may be
                  used to determine if an item should be removed from the 
                  station.
     *  @return the item if you decide to remove it, or null otherwise
     */
    public CookingItem tend(int removeThreshold, int penaltyThreshold) {
        if (this.getValue().timeRemaining() <= removeThreshold 
                || this.getValue().penalty() <= penaltyThreshold) {
            return this.remove();
        } else {
            return null;
        }
    }
}
