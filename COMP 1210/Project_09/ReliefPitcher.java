/** A class that gives data of ReliefPitcher.
* 
* Project_09 
* @author Carlton Schmieder
* @version 4-4-19
**/
public class ReliefPitcher extends Pitcher {
   private int saves; 
   
   /** 
   * A constuctor for the ReliefPitcher class. 
   * @param numberIn  
   * @param nameIn  
   * @param positionIn  
   * @param specializationIn  
   * @param battingAvgIn   
   * @param winsIn   
   * @param lossesIn  
   * @param eraIn   
   * @param savesIn   
   **/
   public ReliefPitcher(String numberIn, String nameIn, String positionIn,
      double specializationIn, double battingAvgIn, int winsIn,
         int lossesIn, double eraIn, int savesIn) {
      super(numberIn, nameIn, positionIn, specializationIn, 
               battingAvgIn, winsIn, lossesIn, eraIn);
      saves = savesIn; 
   } 
   
   /** A method to get saves. 
   * @return saves
   **/ 
   public int getSaves() {
      return saves; 
   } 
   
   /** A method to set saves.
   * @param savesIn 
   **/ 
   public void setSaves(int savesIn) {
      saves = savesIn; 
   }
   
   /** A method to get the rating. 
   * @return rating 
   **/ 
   public double rating() {
      return BASE_RATING * specialization * (1 / (1 + era)) 
         * ((wins - losses + saves) / 30.0);
   }
   
   /** A method to get the stats.
   * @return stats
   **/ 
   public String stats() { 
      String stats; 
      stats = getWins() + " wins, " + getLosses() + " losses, " 
         + getSaves() + " saves, " + getEra() + " ERA"; 
      return stats;
   }
} 
