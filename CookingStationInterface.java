/**
 * Interface for a Cooking station, based on the code
 * provided in the assignment document.
 *
 * @author Joanne Selinski
 */

public interface CookingStationInterface {

    /** Put a new dish at the end of the station.
     *  @param it the dish to add
     */
    void addItem(CookingItem it);

    /** Simulate one minute time passing for this station.
     */
    void tick();

    /** Tend the current item.
     *  @param removeThreshold the number of minutes that may be used to 
     *            determine if an item should be removed from the station.
     *  @param penaltyThreshold the limit on the penalty value that may be
     *            used to determine if an item should be removed from the 
     *            station.
     *  @return the item if you decide to remove it, or null otherwise
     */
    CookingItem tend(int removeThreshold, int penaltyThreshold);
}
