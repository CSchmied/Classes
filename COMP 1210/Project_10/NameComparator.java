import java.util.Comparator;
/** A class to create the name Comparator. **/ 
public class NameComparator implements Comparator<SoftballPlayer> {
  
  /** The only method to make Name comparator to work. 
  * @param p1 
  * @param p2 
  * @return compare 
  **/
   public int compare(SoftballPlayer p1, SoftballPlayer p2) {  
      int spaceP1 = p1.name.indexOf(" "); 
      String firstNameP1 = p1.name.substring(0, spaceP1); 
      String lastNameP1 = p1.name.substring(spaceP1);
      
      int spaceP2 = p2.name.indexOf(' '); 
      String firstNameP2 = p2.name.substring(0, spaceP2);
      String lastNameP2 = p2.name.substring(spaceP2); 
      
      return (lastNameP1 
         + firstNameP1).toLowerCase().compareTo((lastNameP2 
            + firstNameP2).toLowerCase()); 
   }

}