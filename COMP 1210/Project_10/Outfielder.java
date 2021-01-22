/** 
* An extension of SoftballPlayer that is the class Outfielder.
*
* Project_09
* @author Carlton Schmieder
* @version 4-4-19
**/
public class Outfielder extends SoftballPlayer {
   private double outfielderFieldingAvg;
   
   /** 
   * A constructor for outfield class.
   * @param numberIn  
   * @param nameIn  
   * @param positionIn  
   * @param specializationIn   
   * @param battingAvgIn  
   * @param outfielderFieldingAvgIn   
   **/  
   public Outfielder(String numberIn, String nameIn, String positionIn,
      double specializationIn, double battingAvgIn, 
         double outfielderFieldingAvgIn) { 
      super(numberIn, nameIn, positionIn, specializationIn, battingAvgIn);
      outfielderFieldingAvg = outfielderFieldingAvgIn;
   }
   
   /** 
   * A method to get Fielding average.
   * @return outfielderFieldingAvg
   **/
   public double getOutfielderFieldingAvg() {
      return outfielderFieldingAvg;
   }
   
   /** 
   * A method to set the fielding average. 
   * @param outfielderFieldingAvgIn  
   **/
   public void setOutfielderFieldingAvg(double outfielderFieldingAvgIn) { 
      outfielderFieldingAvg = outfielderFieldingAvgIn; 
   }
   
   /** 
   * A method to get the rating.
   * @return rating. 
   **/ 
   public double rating() { 
      return BASE_RATING * specialization * battingAvg 
         * outfielderFieldingAvg; 
   }  
      
}