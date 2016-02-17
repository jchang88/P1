/**
 * Cooking station class implementation.
 * Each station is implemented with a circular linked list data structure.
 * Based on the Cooking Station interface provided in the assignment document.
 *
 * @author Joanne Selinski, Steven Chen, Jeffrey Chang
 */

public class CookingStation extends CList<CookingItem> implements CookingStationInterface {
    
    /** Name of station. */
    private String name;


    /** Put a new dish at the end of the station.
     *  @param it the dish to add
     */
    public void addItem(CookingItem it) {

    }

    /** Simulate one minute time passing for this station.
     */
    public void tick() {

    }

    /** Tend the current item
     *  @param removeThreshold the number of minutes that may be used to 
     *            determine if an item should be removed from the station.
     *  @param penaltyThreshold the limit on the penalty value that may be
                  used to determine if an item should be removed from the station.
     *  @return the item if you decide to remove it, or null otherwise
     */
    public CookingItem tend(int removeThreshold, int penaltyThreshold) {

    }
}
