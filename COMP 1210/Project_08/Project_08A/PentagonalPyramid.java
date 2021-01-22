import java.text.DecimalFormat;

/** 
* A program that calculates the surface area and 
volume of a pentagonal pyramidal in interactions. 
*
* Project_04
* @author Carlton Schmieder
* @version 1-6-19 
*/ 
public class PentagonalPyramid 
{
//Fields 
   private String label = ""; 
   private double baseEdge = 0; 
   private double height = 0; 
   private static int count = 0; 
    
//Constructors 
/** 
* Constructor to declare all the given instance variables.
* @param heightIn   
  @param labelIn   
  @param baseEdgeIn   
*/ 
   public PentagonalPyramid(String labelIn, double baseEdgeIn, double heightIn)
   { 
      setLabel(labelIn);
      setBaseEdge(baseEdgeIn);
      setHeight(heightIn);
      count++;  
   }
   /** 
   * If label is not equal to null, then it returns true.
   * @param labelIn  
   * @return tag used   
   */
   public boolean setLabel(String labelIn) {
   
      if (labelIn != null) {
         label = labelIn;
         return true;
      }
      else {
         return false;
      } 
   }
   /** 
   * If baseEdge is greater than zero, then return true. 
   * @param baseEdgeIn 
   * @return tag used
   */
   public boolean setBaseEdge(double baseEdgeIn) { 
      if (baseEdgeIn > 0) {
         baseEdge = baseEdgeIn;
         return true; 
      } 
      else { 
         return false;
      } 
   }
   /** 
   * If the height is greater than zero, then return true. 
   * @param heightIn   
   * @return tag - used 
   */ 
   public boolean setHeight(double heightIn) { 
      if (heightIn > 0) {
         height = heightIn;
         return true; 
      }
      else { 
         return false; }
         
   }   
   /** 
   * Method to get label, then return label. 
   * @return tag used 
   */ 
   public String getLabel() {
      return label; 
   }  
   /** 
   * Method to get height, and then return height. 
   * @return tag used
   */ 
   public double getHeight() {
      return height;
   }
   /** 
   * Method to get the base edge, and then return base edge. 
   * @return tag used
   */ 
   public double getBaseEdge() { 
      return baseEdge; 
   } 
   /** 
   * Method to calculate the value of the surface area. 
   * @return tag used
   */ 
   public double surfaceArea() {
      double surfaceArea = 0;
      surfaceArea = ((double) 5 / 4) * (Math.tan(Math.toRadians(54))) 
         * Math.pow(baseEdge, 2);
      surfaceArea = surfaceArea + (5 * (baseEdge / 2)) 
         * (Math.sqrt(Math.pow(height, 2) 
               + Math.pow((baseEdge * Math.tan(Math.toRadians(54)) / 2), 2)));
      return surfaceArea; 
   }
   /** 
   * Method to calculate the value of volume. 
   * @return tag used 
   */ 
   public double volume() {
      double volume = 0;
      volume = ((double) 5 / 12) * (Math.tan(Math.toRadians(54)) * (height) 
         * (Math.pow(baseEdge, 2)));
      return volume;
   }
   /** 
   * String to print the output stating all the different values. 
   * @return tag used 
   */
   public String toString() {
   
      DecimalFormat df = new DecimalFormat("#,##0.0######");
      String output = "PentagonalPyramid \"" + label + "\""; 
      output +=  " with base edge = " + baseEdge
         + " and height = " + height + " units has:\n"; 
      output += "\tsurface area = " + df.format(surfaceArea()) 
         + " square units\n"; 
      output += "\tvolume = " + df.format(volume()) + " cubic units\n"; 
      return output; 
   }  
   
///////////////////////New Code Project 8///////////////////
///////////////////////////////////////////////////////////
   /** A method to get the count. 
   * @return count
   */
   public static int getCount() {
      return count; 
   } 
    
    /** A method to reset the count. */ 
   public static void resetCount() {
      count = 0; 
      
   }  
   
   /** 
   * A method to return false if the object 
   does not equal the instance.
   * @return false 
   * @param obj 
   */
   public boolean equals(Object obj) { 
      if (!(obj instanceof PentagonalPyramid)) {
         return false; 
      }
      else { 
         PentagonalPyramid d = (PentagonalPyramid) obj;
         return (label.equalsIgnoreCase(d.getLabel()) 
            && Math.abs(baseEdge - d.getBaseEdge()) < .000001 
            && Math.abs(height - d.getHeight()) < .000001); 
      }
   }   
   
   /** A method that returns zero when used.
   * @return 0 
   */
   public int hashCode() {
      return 0; 
   } 
 
         
      
   
     
}
       
