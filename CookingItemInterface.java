/** 
 * Interface for the cooking items for Cutthroat Kitchen assingment.
 * Code based on the code provided in the  p1 assignment document.
 *
 * @author Joanne Selinski
 * 600.226.02
 * Assignment p1
 */

public interface CookingItemInterface {
    /** Implements a simulation of one minute of time for this item by
     *  decrementing cooking time by one minute.
     */
    void tick(); 

    /** Get the time remaining for cooking this dish.
     *  @return the time in minutes
     */
    int timeRemaining();

    /** Calculate the penalty if this dish were removed now.
     *  @return the penalty
     */
    int penalty(); 
}
