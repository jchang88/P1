/**
 * Implementation of the cooking items interface.
 *
 * @author Joanne Selinski, Steven Chen schen107, Jeffrey Chang jchang88
 * 600.226.02
 * Assignment p1
 */

public class CookingItem implements CookingItemInterface {
    /** instance variable for the name of the dish */
    private String name;
    /** instance variable for the remaining cooking time */
    private int cookingTime;
    /** instance variable for the last time this dish was checked */
    private int timeChecked;
    /** instance variable for the undercooked penalty per minute for this dish */
    private int uPen;
    /** instance variable for the overcooked penalty per minute for this dish */
    private int oPen;
   
    /**
     * Public constructor to create the cooking item.
     * @param n the name of the dish
     * @param cT the remaining cooking time
     * @param tC the last time that the dish was checked
     * @param pPM the penalty per minute of this dish
     */
    public CookingItem(String n, int cT, int u, int o) {
         this.name = n;
         this.cookingTime = cT;
         this.uPen = u;
         this.oPen = o;
         this.timeChecked = 0;
    }    

    /** Implements a simulation of one minute of time for this item by
     * decrementing cooking time by one minute
     */
    public void tick() {
         this.cookingTime--;
    }

    /** Get the time remaining for cooking this dish.
     * @return the time in minutes
     */
    public int timeRemaining() {
         return this.cookingTime;
    }
    
    /** Calculate the penalty if this dish were removed now.
     * @return the penalty
     */
    public int penalty() {
         if (this.cookingTime < 0) {
             return this.cookingTime * oPen;
         } else {
             return this.cookingTime * uPen;
         }
    }
}
