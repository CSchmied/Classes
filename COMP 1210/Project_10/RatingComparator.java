import java.util.Comparator; 
/** A class to create the rating comparator. **/ 
public class RatingComparator implements Comparator<SoftballPlayer> { 
   
   /** A method to make the rating comparator work.
   * @param p1 
   * @param p2 
   * @return the compare result 
   **/
   public int compare(SoftballPlayer p1, SoftballPlayer p2) {
      return (int) (p2.rating() * 10000 - p1.rating() * 10000);
   }
}