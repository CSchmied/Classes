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

public class PentagonalPyramidList2 
{
//Fields    
   private String plistName; 
   private PentagonalPyramid[] objects;
   private int pentObjects;  
   
 // Constructor 
 /** 
 * Constructor including all given instance variables.
 * @param plistNameIn  
 * @param objectsIn 
 * @param pentObjectsIn   
 */
   public PentagonalPyramidList2(String plistNameIn, 
      PentagonalPyramid[] objectsIn, int pentObjectsIn) { 
      plistName = plistNameIn;
      objects = objectsIn;
      pentObjects = pentObjectsIn;
   
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
      return pentObjects; 
   }
    
    /** 
    * @return totalSA caluclated from the surface
    area formula. 
    */  
   public double totalSurfaceArea() {
      double totalSA = 0;
      int index = 0; 
      while (index < pentObjects) {
         totalSA += objects[index].surfaceArea();  
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
      while (index < pentObjects) {
         totalV += objects[index].volume(); 
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
      if (pentObjects > 0) { 
         while (index < pentObjects) { 
            aveSA = totalSurfaceArea() / pentObjects; 
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
      if (pentObjects > 0) {
         while (index < pentObjects) {
            aveV = totalVolume() / pentObjects; 
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
      while (index < pentObjects) { 
         result += "\n" + objects[index]; 
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
      result += "----- Summary for " + getName() + " -----\n"; 
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
   public PentagonalPyramid[] getList() {
      return objects; 
   }          
   
   /** 
   * Method that reads the file for the menu app.
   * @param fileNameIn   
   * @return listTwo
   * @throws FileNotFoundException   
   */ 
   public PentagonalPyramidList2 readFile(String fileNameIn)
      throws FileNotFoundException {
      String listName = ""; 
      Scanner scan = new Scanner(new File(fileNameIn));
      PentagonalPyramid[] listOne = new PentagonalPyramid[20];
      int numPent = 0;
      String label = ""; 
      double baseEdge = 0; 
      double height = 0;
      
      listName = scan.nextLine(); 
      
      while (scan.hasNext()) {
         label = scan.nextLine().trim(); 
         baseEdge = Double.parseDouble(scan.nextLine());
         height = Double.parseDouble(scan.nextLine()); 
         PentagonalPyramid p = new PentagonalPyramid(label, baseEdge, height);
         listOne[numPent] = p;
         numPent++; 
         
      }
      
      PentagonalPyramidList2 listTwo = new PentagonalPyramidList2(listName,
          listOne, numPent); 
   
      
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
      
      objects[pentObjects] = pAdd;
      pentObjects++;
   } 
   
   /**
   * Method that allows you to find a pyramid.
   * @param labelIn  
   * @return tag
   */ 
   public PentagonalPyramid findPentagonalPyramid(String labelIn) {
      
      PentagonalPyramid result = null; 
      
      for (int i = 0; i < pentObjects; i++) { 
         if (objects[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = objects[i];
            break; 
         } 
      }
      return result;
   }
   
   /** 
   * Method that deletes the selected pentagonal pyramid.
   * @param labelIn  
   * @return result  
   */ 
   public PentagonalPyramid deletePentagonalPyramid(String labelIn) {
      
      PentagonalPyramid result = null; 
      
      for (int i = 0; i < pentObjects; i++) { 
         if (objects[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = objects[i]; 
            for (int j = i; j < pentObjects - 1; j++) {
               objects[j] = objects[j + 1];
            }
            objects[pentObjects - 1] = null;
            pentObjects--;
            break;
         } 
      }
      return result;
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
   
/*****************************************************************.
************************* NEW METHODS ****************************.
******************************************************************/

/** 
* Method to find the shortest base edge. 
* @return objects
**/ 
   public PentagonalPyramid findPentagonalPyramidWithShortestBaseEdge() {
      double shortest = 0; 
      int indexOfShortest = 0; 
      int index = 0; 
      while (index < pentObjects) { 
         if (objects[indexOfShortest].getBaseEdge() 
            > objects[index].getBaseEdge()) { 
            indexOfShortest = index;
         }
         index++; 
      }
      
      if (pentObjects > 0) {
         return objects[indexOfShortest];
      } 
         
      else {
         return null; 
      } 
   }
   
   /** 
   * Method to find Longest base edge.
   * @return objects
   **/ 
   public PentagonalPyramid findPentagonalPyramidWithLongestBaseEdge() {
      double longest = 0; 
      int indexOfLongest = 0; 
      int index = 0; 
      while (index < pentObjects) { 
         if (objects[indexOfLongest].getBaseEdge() 
            < objects[index].getBaseEdge()) { 
            indexOfLongest = index;
         }
         index++; 
      }
      
      if (pentObjects > 0) {
         return objects[indexOfLongest];
      } 
         
      else {
         return null; 
      } 
   }
   
   /** 
   * Method to find largest volume. 
   * @return objects
   **/ 
   public PentagonalPyramid findPentagonalPyramidWithLargestVolume() {
      double largest = 0; 
      int indexOfLargest = 0; 
      int index = 0; 
      while (index < pentObjects) { 
         if (objects[indexOfLargest].volume() 
            < objects[index].volume()) { 
            indexOfLargest = index;
         }
         index++; 
      }
      
      if (pentObjects > 0) {
         return objects[indexOfLargest];
      } 
         
      else {
         return null; 
      } 
   }
   
   /** 
   * Method to find smallest volume.
   * @return objects
   **/ 
   public PentagonalPyramid findPentagonalPyramidWithSmallestVolume() {
      double smallest = 0; 
      int indexOfSmallest = 0; 
      int index = 0; 
      while (index < pentObjects) { 
         if (objects[indexOfSmallest].volume() 
            > objects[index].volume()) { 
            indexOfSmallest = index;
         }
         index++; 
      }
      
      if (pentObjects > 0) {
         return objects[indexOfSmallest];
      } 
         
      else {
         return null; 
      } 
   }




    
}