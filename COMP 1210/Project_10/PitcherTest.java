import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** A test class for Pitcher. **/
public class PitcherTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


  /** A test for all the getters. **/ 
   @Test public void gettersTest() { 
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85); 
   
      Assert.assertEquals(22, p3.getWins());
   
      Assert.assertEquals(4, p3.getLosses()); 
   
      Assert.assertEquals(2.85, p3.getEra(), 0.5);
   }
   
   /** A test for all the setters. **/ 
   @Test public void settersTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85); 
      
      p3.setWins(25); 
      Assert.assertEquals(25, p3.getWins()); 
      
      p3.setLosses(2); 
      Assert.assertEquals(2, p3.getLosses()); 
      
      p3.setEra(1.50);
      Assert.assertEquals(1.50, p3.getEra(), 0.5); 
   }  
   
   /** A test for the stats method. **/ 
   @Test public void statsTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85); 
   
      Assert.assertEquals(true, 
         p3.stats().contains("22 wins, 4 losses, 2.85 ERA")); 
   }
   
   /** A test for the toString method. **/ 
   @Test public void toStringTest() { 
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      
      Assert.assertEquals(true, p3.toString().contains("43 Jo Williams (RHP)"));
   }
   
   /** A test for the rating method. **/ 
   @Test public void ratingTest() {
      Pitcher p3 = new Pitcher("43", "Jo Williams", "RHP", 
         2.0, .125, 22, 4, 2.85);
      
      Assert.assertEquals(3.74, p3.rating(), 0.5); 
   }

}
