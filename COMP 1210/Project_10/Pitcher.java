/** 
* A class to give the pitcher data. 
*
* Project_09
* @author Carlton Schmieder
* @version 4-4-19 
**/
public class Pitcher extends SoftballPlayer {
   protected int wins; 
   protected int losses; 
   protected double era; 

/** A constuctor that declares the number, name, position, 
   specialization, batting average, wins, losses, and era. 
 * @param numberIn  
 * @param nameIn  
 * @param positionIn  
 * @param specializationIn  
 * @param battingAvgIn  
 * @param winsIn   
 * @param lossesIn    
 * @param eraIn  
 **/
   public Pitcher(String numberIn, String nameIn, String positionIn, 
      double specializationIn, double battingAvgIn, int winsIn, 
      int lossesIn, double eraIn) {
      super(numberIn, nameIn, positionIn, specializationIn, battingAvgIn);
      wins = winsIn; 
      losses = lossesIn; 
      era = eraIn; 
   }
   
   /** A method to get wins. 
   * @return wins
   **/ 
   public int getWins() {
      return wins;
   } 
      
   /** A method to set wins. 
   * @param winsIn 
   **/ 
   public void setWins(int winsIn) {
      wins = winsIn;
   } 
   
   /** A method to get losses. 
   * @return losses 
   **/ 
   public int getLosses() {
      return losses; 
   } 
   
   /** A method to set losses. 
   * @param lossesIn 
   **/ 
   public void setLosses(int lossesIn) {
      losses = lossesIn; 
   } 
   
   /** A method to get era. 
   * @return era
   **/ 
   public double getEra() { 
      return era; 
   }
   
   /** A method to set era. 
   * @param eraIn   
   **/ 
   public void setEra(double eraIn) {
      era = eraIn; 
   }
   
   /** A method to get the rating. 
   * @return rating. 
   **/ 
   public double rating() { 
      double value = BASE_RATING * specialization * (1 / (1 + era)) 
         * ((wins - losses) / 25.0); 
      return value; 
   }
   
   /** A method to print out the stats. 
   * @return stats
   **/
   public String stats() {
      String stats;
      stats = getWins() + " wins, " + getLosses() 
         + " losses, " + getEra() + " ERA";
      return stats;
   
      
   } 
      
   
} 
 
