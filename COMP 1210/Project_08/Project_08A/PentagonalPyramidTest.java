import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** A class that test all the methods from PentagonalPyramid class. **/
public class PentagonalPyramidTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test for the method setLabel being true. **/
   @Test public void trueLabel() {
      PentagonalPyramid trueLabel = new PentagonalPyramid("TLabel", 1, 1);
      Assert.assertTrue(trueLabel.setLabel("TLabel")); 
   }
   
     /** A test for the method setLabel being false. **/
   @Test public void falseLabel() {
      PentagonalPyramid falseLabel = new PentagonalPyramid("FLabel", 1, 1);
      Assert.assertFalse(falseLabel.setLabel(null)); 
   }
  
  /** A test for the method setBaseEdge being true. **/  
   @Test public void trueBaseEdge() { 
      PentagonalPyramid base = new PentagonalPyramid("BaseEdge", 5, 5);
      Assert.assertTrue(base.setBaseEdge(5)); 
   }
  /** A test for the method setBaseEdge being false. **/ 
   @Test public void falseBaseEdge() {    
      PentagonalPyramid notBase = new PentagonalPyramid("NotBase Edge", -5, 5);
      Assert.assertFalse(notBase.setBaseEdge(-5));
   }
  
   /** A test for the method setHeight being true. **/
   @Test public void trueHeight() { 
      PentagonalPyramid height = new PentagonalPyramid("Height", 5, 5); 
      Assert.assertTrue(height.setHeight(5)); 
   }
   
   /** A test for the method setHeight being false. **/
   @Test public void falseHeight() { 
      PentagonalPyramid notHeight = new PentagonalPyramid("NotHeight", 5, -5); 
      Assert.assertFalse(notHeight.setHeight(-5));
   } 
   
   /** A test for all getter methods. **/
   @Test public void getLabel() { 
      PentagonalPyramid test = new PentagonalPyramid("Test", 1, 1);
      Assert.assertEquals("Test", test.getLabel()); 
      Assert.assertEquals(1, test.getHeight(), 0.5);
      Assert.assertEquals(1, test.getBaseEdge(), 0.5);
   }
   
   /** A test for the method surfaceArea. **/ 
   @Test public void surfaceArea() { 
      PentagonalPyramid surfaceArea = new PentagonalPyramid("SA", 1, 1); 
      Assert.assertEquals(4.75, surfaceArea.surfaceArea(), 0.5);
   } 
   
   /** A test for the method volume. **/ 
   @Test public void volume() { 
      PentagonalPyramid volume = new PentagonalPyramid("V", 1, 1); 
      Assert.assertEquals(0.5, volume.volume(), 0.5);
   } 
   
   /** A test for the string method. **/ 
   @Test public void testToString() {
      PentagonalPyramid string = new PentagonalPyramid("Test String", 1, 1);
      Assert.assertEquals(true, 
         string.toString().contains("PentagonalPyramid \"Test String\" "
         + "with base edge = 1.0 and height = 1.0 units has"));
   } 
   
   /** A test for the method getCount. **/ 
   @Test public void testCount() {
      PentagonalPyramid.resetCount();
      PentagonalPyramid test = new PentagonalPyramid("Test", 1, 1);
      Assert.assertEquals(1, test.getCount(), 0.0000001); 
   }
   
   /** A test for the method resetCount. **/ 
   @Test public void testResetCount() { 
      PentagonalPyramid.resetCount();
     //PentagonalPyramid test = new PentagonalPyramid("Test", 1, 1); 
      Assert.assertEquals(0, PentagonalPyramid.getCount(), 0.000001); 
   }
   
   /** A test for the method equals. **/
   @Test public void testEquals() { 
      PentagonalPyramid test1 = new PentagonalPyramid("Test", 1, 1); 
      PentagonalPyramid test2 = new PentagonalPyramid("Test", 1, 1);
      Assert.assertEquals(true, test1.equals(test2));
      
      test2 = new PentagonalPyramid("Test2", 1, 1);
      Assert.assertEquals(false, test1.equals(test2)); 
      
      test2 = new PentagonalPyramid("Test", 2, 1);
      Assert.assertEquals(false, test1.equals(test2)); 
      
      test2 = new PentagonalPyramid("Test", 1, 2);
      Assert.assertEquals(false, test1.equals(test2)); 
      
      Assert.assertEquals(false, test1.equals("test")); 
      
      Assert.assertEquals(0, test1.hashCode()); 
   } 
 
 
  

      

      
   
   /** A test that always fails. 
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
   */
}
