import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/** A test method for NameComparator. **/
public class NameComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** A test for nameComparator. 
   * @throws IOException 
   **/
   @Test public void compareTest() throws IOException {
      SoftballTeam t1 = new SoftballTeam(); 
      t1.readPlayerFile("softball_player_data2.csv"); 
      String output = t1.generateReportByName();
      
      boolean compare = output.substring(18, 25).equals("18 Carlton Schmieder")
         && output.substring(100, 150).equals("32 Pattie Jack");
         
      Assert.assertEquals(false, compare); 
   }
      
}
