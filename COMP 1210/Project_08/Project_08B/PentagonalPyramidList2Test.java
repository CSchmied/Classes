import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/** Test class for the PentagonalPyramidList2. **/
public class PentagonalPyramidList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /** Test for name and number of pentagonal pyramids. **/
   @Test public void nameandNumberOfPentPyr() {
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3); 
      
      Assert.assertEquals("Test List", pList.getName()); 
      
      Assert.assertEquals(3, pList.numberOfPentagonalPyramids()); 
   } 
   
   /** Test for surface area and volume. **/ 
   @Test public void totalSurfaceAreaAndVolumeTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3); 
      
      Assert.assertEquals(20.65, pList.totalVolume(), 0.05); 
      Assert.assertEquals(66.57, pList.totalSurfaceArea(), 0.05);
   }
   
   /** Test for average surface area and volume. **/
   @Test public void averageSurfaceAreaAndVolume() {
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3);
      
      Assert.assertEquals(6.88, pList.averageVolume(), 0.05); 
      Assert.assertEquals(22.19, pList.averageSurfaceArea(), 0.05); 
      
      PentagonalPyramid[] noArray = new PentagonalPyramid[10];
      PentagonalPyramidList2 noList = 
         new PentagonalPyramidList2("No List", noArray, 0); 
      Assert.assertEquals(0, noList.averageVolume(), 0.05);
      Assert.assertEquals(0, noList.averageSurfaceArea(), 0.05);
   }
   
   /** Test for toString. **/
   @Test public void toStringTest() {
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3); 
      
      Assert.assertEquals(true, pList.toString().contains("Test List")); 
   }
   
   /** Test for summary info. **/
   @Test public void summaryInfoTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3); 
         
      Assert.assertEquals(true, 
         pList.summaryInfo().contains("----- Summary for Test List -----")); 
   }

   
   /** Test for the readFile.
   ** @throws FileNotFoundException **/
   @Test public void readFileTest() throws FileNotFoundException {
      PentagonalPyramid[] pentArray = new PentagonalPyramid[20];
      pentArray[0] = new PentagonalPyramid("Ex1", 1, 2);
      pentArray[1] = new PentagonalPyramid("Ex 2", 12.3, 25.5); 
      pentArray[2] = new PentagonalPyramid("Ex 3", 123.4, 900.0); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", new PentagonalPyramid[20], 0);
      pList = pList.readFile("PentagonalPyramid_data_1.txt"); 
      
      Assert.assertArrayEquals(pList.getList(), pentArray);
   }   
   
   /** Test for add PentagonalPyramid. **/ 
   @Test public void addPyramidTest() {
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3); 
      
      PentagonalPyramid addTest = new PentagonalPyramid("addTest", 4, 4); 
      pList.addPentagonalPyramid("addTest", 4, 4);
      PentagonalPyramid[] testAdd = pList.getList();
      Assert.assertEquals(addTest, testAdd[3]); 
   }
   
   /** Test for find PentagonalPyramid. **/ 
   @Test public void findPyramidTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3); 
      
      PentagonalPyramid notThere = null; 
      Assert.assertEquals(pentArray[0], pList.findPentagonalPyramid("Pent1"));
      Assert.assertEquals(notThere, pList.findPentagonalPyramid("Pent4"));
   }
   
   /** Test for delete PentagonalPyramid. **/ 
   @Test public void deletePyramidTest() {
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3); 
      
      PentagonalPyramid pent = new PentagonalPyramid("Pent2", 2, 2);
      PentagonalPyramid notThere = null; 
      PentagonalPyramid[] pd = pList.getList(); 
      Assert.assertEquals(pent, pList.deletePentagonalPyramid("Pent2"));
      Assert.assertEquals(notThere, pList.deletePentagonalPyramid("Pent4"));  
   }
   
   /** Test for edit. **/ 
   @Test public void editPyramidTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3);
      
      Assert.assertTrue("Pent1", pList.editPentagonalPyramid("Pent1", 2, 3)); 
      
      Assert.assertFalse("Pent4", pList.editPentagonalPyramid("Pent4", 2, 2)); 
   }
   
   /** Test for Shortest Base Edge. **/ 
   @Test public void shortestBaseEdgeTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 4, 7);
      pentArray[1] = new PentagonalPyramid("Pent2", 8, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 2, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3);
      
      Assert.assertEquals(pentArray[2], 
         pList.findPentagonalPyramidWithShortestBaseEdge()); 
         
      PentagonalPyramid[] noArray = new PentagonalPyramid[10];
      PentagonalPyramidList2 noList = 
         new PentagonalPyramidList2("No List", noArray, 0); 
      Assert.assertEquals(null, 
         noList.findPentagonalPyramidWithShortestBaseEdge());
   }
   
   /** Test for Longest Base Edge. **/ 
   @Test public void longestBaseEdgeTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3);
      
      Assert.assertEquals(pentArray[2], 
         pList.findPentagonalPyramidWithLongestBaseEdge());
      
      PentagonalPyramid[] noArray = new PentagonalPyramid[10];
      PentagonalPyramidList2 noList = 
         new PentagonalPyramidList2("No List", noArray, 0); 
      Assert.assertEquals(null, 
         noList.findPentagonalPyramidWithLongestBaseEdge());
   
   }
   
   /** Test for Smallest Volume. **/ 
   @Test public void smallestVolumeTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 4, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 6, 9); 
      pentArray[2] = new PentagonalPyramid("Pent3", 2, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3);
      
      Assert.assertEquals(pentArray[2], 
         pList.findPentagonalPyramidWithSmallestVolume());
         
      PentagonalPyramid[] noArray = new PentagonalPyramid[10];
      PentagonalPyramidList2 noList = 
         new PentagonalPyramidList2("No List", noArray, 0); 
      Assert.assertEquals(null, 
         noList.findPentagonalPyramidWithSmallestVolume());
   } 
   
   /** Test for Largest Volume. **/ 
   @Test public void largestVolumeTest() { 
      PentagonalPyramid[] pentArray = new PentagonalPyramid[10];
      pentArray[0] = new PentagonalPyramid("Pent1", 1, 1);
      pentArray[1] = new PentagonalPyramid("Pent2", 2, 2); 
      pentArray[2] = new PentagonalPyramid("Pent3", 3, 3); 
      
      PentagonalPyramidList2 pList = 
         new PentagonalPyramidList2("Test List", pentArray, 3);
      
      Assert.assertEquals(pentArray[2],  
         pList.findPentagonalPyramidWithLargestVolume());
         
      PentagonalPyramid[] noArray = new PentagonalPyramid[10];
      PentagonalPyramidList2 noList = 
         new PentagonalPyramidList2("No List", noArray, 0); 
      Assert.assertEquals(null, 
         noList.findPentagonalPyramidWithLargestVolume());
   }

   
      

   
    
      
      
   
   

      

      

      



}
