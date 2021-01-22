import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** Test for the Infielder class. **/
public class InfielderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test for all the getters. **/ 
   @Test public void gettersTest() { 
      Infielder p1 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850);  
      
      Assert.assertEquals("Jackie Smith", p1.getName()); 
      
      Assert.assertEquals("23", p1.getNumber()); 
      
      Assert.assertEquals("3B", p1.getPosition()); 
      
      Assert.assertEquals(1.25, p1.getSpecializationFactor(), 0.5); 
      
      Assert.assertEquals(.275, p1.getBattingAvg(), 0.5); 
      
      Assert.assertEquals(.850, p1.getInfielderFieldingAvg(), 0.5); 
      
      p1.resetCount();
      Assert.assertEquals(0, p1.getCount(), 0.5); 
      
   }
   
   /** Test for all the setter Methods. **/ 
   @Test public void settersTest() {
      Infielder p1 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850); 
    
      p1.setNumber("18"); 
      Assert.assertEquals("18", p1.getNumber());
      
      p1.setName("Carlton Schmieder"); 
      Assert.assertEquals("Carlton Schmieder", p1.getName()); 
      
      p1.setPosition("LF"); 
      Assert.assertEquals("LF", p1.getPosition()); 
      
      p1.setSpecializationFactor(2.0); 
      Assert.assertEquals(2.0, p1.getSpecializationFactor(), 0.5); 
      
      p1.setBattingAvg(.500); 
      Assert.assertEquals(.500, p1.getBattingAvg(), 0.5);
      
      p1.setInfielderFieldingAvg(.960); 
      Assert.assertEquals(.960, p1.getInfielderFieldingAvg(), 0.5);
      
   }
   
   /** A test for the stats method. **/ 
   @Test public void statsTest() { 
      Infielder p1 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850); 
      Assert.assertEquals(true, p1.stats().contains(".275"));
   }
   
   /** A test for the toString. **/ 
   @Test public void toStringTest() {
      Infielder p1 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850); 
      Assert.assertEquals(true, p1.toString().contains("23 Jackie Smith (3B)"));
   }
   
   /** A test for the rating method. **/
   @Test public void ratingTest() {
      Infielder p1 = new Infielder("23", "Jackie Smith", 
         "3B", 1.25, .275, .850); 
      Assert.assertEquals(2.92, p1.rating(), 0.5); 
   }


}
