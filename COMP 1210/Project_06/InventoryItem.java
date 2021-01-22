/** A class that represents the items inventory in a store. **/ 
public class InventoryItem { 
   protected String name; 
   protected double price; 
   private static double taxRate = 0; 
   
   /** Constructor for InventoryItem.
   * @param nameIn 
   * @param priceIn  
   **/
   public InventoryItem(String nameIn, double priceIn) { 
      name = nameIn; 
      price = priceIn;
   } 
    /** String to get name.
    * @return name
    **/   
   public String getName() { 
      return name; 
   } 
     
     /** Calculates cost. 
     * @return price 
     **/
   public double calculatorCost() { 
      return price * (1 + taxRate);
   } 
     
     /** Sets tax rate.
     * @param taxRateIn  
     **/ 
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn; 
   } 
      
     /** String. 
     * @return name
     **/ 
   public String toString() { 
      return name + ": $" + calculatorCost(); 
   } 
}