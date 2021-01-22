import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** A test class for ReliefPitcher class. **/
public class ReliefPitcherTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

    /** Test for getSaves. **/ 
   @Test public void getSavesTest() { 
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP", 
         2.0, .125, 5, 4, 3.85, 17);
     
      Assert.assertEquals(17, p4.getSaves()); 
   }
   
   /** Test for setSaves. **/ 
   @Test public void setSavesTest() { 
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP", 
         2.0, .125, 5, 4, 3.85, 17); 
       
      p4.setSaves(20); 
      Assert.assertEquals(20, p4.getSaves()); 
   }
   
   /** A test for stats method. **/ 
   @Test public void statsTest() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP", 
         2.0, .125, 5, 4, 3.85, 17); 
       
      Assert.assertEquals(true, 
         p4.stats().contains("5 wins, 4 losses, 17 saves, 3.85 ERA")); 
   }
   
   /** A test for the rating method. **/ 
   @Test public void ratingTest() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP", 
         2.0, .125, 5, 4, 3.85, 17); 
      
      Assert.assertEquals(2.74, p4.rating(), 0.50); 
   }
   
   /** A test for toString. **/ 
   @Test public void toStringTest() {
      ReliefPitcher p4 = new ReliefPitcher("34", "Sammi James", "LHP", 
         2.0, .125, 5, 4, 3.85, 17); 
      
      Assert.assertEquals(true, 
         p4.toString().contains("34 Sammi James (LHP) 5 wins")); 
   }
 
   
   

}
