import java.util.ArrayList; 
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.File; 

/**  
* A program that stores the name of the list and an
ArrayList and returns summary information. 
*
* Project_05
* @author Carlton Schmieder
* @version 1-20-19 
*/ 

public class PentagonalPyramidList 
{
//Fields    
   private String plistName = ""; 
   private ArrayList<PentagonalPyramid> objects; 
   
 // Constructor 
 /** 
 * Constructor including all given instance variables.
 * @param plistNameIn  
 * @param objectsIn  
 */
   public PentagonalPyramidList(String plistNameIn, 
      ArrayList<PentagonalPyramid> objectsIn) { 
      plistName = plistNameIn;
      objects = objectsIn;
   
   }
     
  // Methods 
  /** 
  * @return listName from the get. 
  */ 
   public String getName() {
      return plistName; 
   } 
   
   /** 
   * @return objects.size() which is the number of 
   pentagonal pyramids. 
   */ 
   public int numberOfPentagonalPyramids() {
      return objects.size(); 
   }
    
    /** 
    * @return totalSA caluclated from the surface
    area formula. 
    */  
   public double totalSurfaceArea() {
      double totalSA = 0;
      int index = 0; 
      while (index < objects.size()) {
         totalSA += objects.get(index).surfaceArea();  
         index++;
      }
      return totalSA; 
   }
   
   /** 
   * @return totalV which is the total volume of
   all pyramids. 
   */
   public double totalVolume() {
      double totalV = 0; 
      int index = 0; 
      while (index < objects.size()) {
         totalV += objects.get(index).volume(); 
         index++;
      }
      return totalV;
   }
   
   /** 
   * @return the average surface area. 
   */ 
   public double averageSurfaceArea() {
      double aveSA = 0; 
      int index = 0; 
      if (objects.size() > 0) { 
         while (index < objects.size()) { 
            aveSA = totalSurfaceArea() / objects.size(); 
            index++;
         } 
         return aveSA;
      } 
      else {
         return 0; 
      } 
   }
  
  /** 
  * @return average volume of all pyramids. 
  */ 
   public double averageVolume() {
      double aveV = 0; 
      int index = 0; 
      if (objects.size() > 0) {
         while (index < objects.size()) {
            aveV = totalVolume() / objects.size(); 
            index++;
         }
         return aveV;
      }
      else { 
         return 0; 
      }
   }  
   
   /** 
   * @return Result of the string.
   */
   public String toString() { 
      String result = plistName + "\n";
      int index = 0; 
      while (index < objects.size()) { 
         result += "\n" + objects.get(index); 
         index++; 
      } 
      return result; 
   }
   
   /** 
   * @return String with the summary information.
   */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##"); 
      String result = "";
      result += "----- Summary for " + plistName + " -----\n"; 
      result += "Number of PentagonalPyramid: " 
         + numberOfPentagonalPyramids() + "\n"; 
      result += "Total Surface Area: " + df.format(totalSurfaceArea()) + "\n"; 
      result += "Total Volume: " + df.format(totalVolume()) + "\n";
      result += "Average Surface Area: " + df.format(averageSurfaceArea()) 
         + "\n";
      result += "Average Volume: " + df.format(averageVolume()) + "\n"; 
   
      return result; 
   }
   //NEW METHODS      
   /**
   * Gets the array list name.
   * @return objects 
   */ 
   public ArrayList<PentagonalPyramid> getList() {
      return objects; 
   }          
   
   /** 
   * Method that reads the file for the menu app.
   * @param fileNameIn   
   * @return listTwo
   * @throws FileNotFoundException  
   */
   public PentagonalPyramidList readFile(String fileNameIn)
      throws FileNotFoundException {
      String listName = ""; 
      Scanner scan = new Scanner(new File(fileNameIn));
      ArrayList<PentagonalPyramid> listOne = new ArrayList<PentagonalPyramid>();
      String label = ""; 
      double baseEdge = 0; 
      double height = 0;
      
      listName = scan.nextLine(); 
      
      while (scan.hasNext()) {
         label = scan.nextLine().trim(); 
         baseEdge = Double.parseDouble(scan.nextLine());
         height = Double.parseDouble(scan.nextLine()); 
         PentagonalPyramid p = new PentagonalPyramid(label, baseEdge, height);
         listOne.add(p);
      }
      
      PentagonalPyramidList listTwo = new PentagonalPyramidList(listName,
          listOne); 
   
      
      return listTwo; 
   }
   
   /**
   * Method to create the add part of the menu.
   * @param labelIn    
   * @param baseEdgeIn  
   * @param heightIn  
   */
   public void addPentagonalPyramid(String labelIn,
       double baseEdgeIn, double heightIn) {
   
      PentagonalPyramid pAdd = new PentagonalPyramid(labelIn,
         baseEdgeIn, heightIn); 
      
      objects.add(pAdd);
   } 
   
   /**
   * Method that allows you to find a pyramid.
   * @param labelIn  
   * @return tag
   */
   public PentagonalPyramid findPentagonalPyramid(String labelIn) {
      PentagonalPyramid f = new PentagonalPyramid("", 0, 0); 
      boolean result = false; 
      for (int i = 0; i < objects.size(); i++) { 
         PentagonalPyramid find = objects.get(i); 
         if (find.getLabel().toUpperCase().equals(labelIn.toUpperCase())) {
            f = find;
            result = true;
            break; 
         } 
      }
      return (result ? f : null);
   }
   
   /** 
   * Method that deletes the selected pentagonal pyramid.
   * @param labelIn  
   * @return result  
   */
   public PentagonalPyramid deletePentagonalPyramid(String labelIn) {
      PentagonalPyramid d = new PentagonalPyramid("", 0, 0);
      boolean result = false;
      for (int i = 0; i < objects.size(); i++) { 
         PentagonalPyramid delete = objects.get(i); 
         if (delete.getLabel().toUpperCase().equals(labelIn.toUpperCase())) {
            objects.remove(i);
            result = true;
            break; 
         }
      } 
      
      return (result ? d : null); 
   }
   /** 
   * Method that allows you to edit a pyramid.
   * @param labelIn  
   * @param baseEdgeIn  
   * @param heightIn  
   * @return tag used
   */
   public boolean editPentagonalPyramid(String labelIn,
       double baseEdgeIn, double heightIn) {
      boolean edit = false;
      PentagonalPyramid p = findPentagonalPyramid(labelIn);
      if (p != null) { 
         p.setBaseEdge(baseEdgeIn); 
         p.setHeight(heightIn);
         edit =  true; }
      return edit; 
   }
}