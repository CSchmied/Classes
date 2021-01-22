import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** A test for the Outfielder class. **/ 
public class OutfielderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** A test for all the getters. **/ 
   @Test public void gettersTest() { 
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950); 
      
      Assert.assertEquals("Pat Jones", p1.getName()); 
      
      Assert.assertEquals("32", p1.getNumber()); 
      
      Assert.assertEquals("RF", p1.getPosition()); 
      
      Assert.assertEquals(1.0, p1.getSpecializationFactor(), 0.5); 
      
      Assert.assertEquals(.375, p1.getBattingAvg(), 0.5); 
      
      Assert.assertEquals(.950, p1.getOutfielderFieldingAvg(), 0.5); 
      
      p1.resetCount();
      Assert.assertEquals(0, p1.getCount(), 0.5); 
      
   }
   
   /** Test for all the setter Methods. **/ 
   @Test public void settersTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
    
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
      
      p1.setOutfielderFieldingAvg(.960); 
      Assert.assertEquals(.960, p1.getOutfielderFieldingAvg(), 0.5);
      
   }
   
   /** A test for the stats method. **/ 
   @Test public void statsTest() { 
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals(true, p1.stats().contains(".375"));
   }
   
   /** A test for the toString. **/ 
   @Test public void toStringTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals(true, p1.toString().contains("32 Pat Jones (RF)"));
   }
   
   /** A test for the rating method. **/
   @Test public void ratingTest() {
      Outfielder p1 = new Outfielder("32", "Pat Jones", "RF", 1.0, .375, .950);
      Assert.assertEquals(3.56, p1.rating(), 0.5); 
   }

}
