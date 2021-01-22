import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException; 

/** A test class for RatingComparator. **/
public class RatingComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

/** A test method for RatingComparator.
* @throws IOException 
**/ 
   @Test public void ratingcompareTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam(); 
      t1.readPlayerFile("softball_player_data2.csv");
      String result = t1.generateReportByRating(); 
      String first = result.substring(131, 140);
      String second = result.substring(974, 985); 
   
      boolean compare = result.substring(131, 141).equals("nina Dobbs")
               && result.substring(974, 985).equals("Erin Noland");
      Assert.assertEquals(false, compare); 
   }
}
