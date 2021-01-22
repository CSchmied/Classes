/** 
* A class that extends from Softball player. 
* 
* Project_09 
* @author Carlton Schmieder
* @version 4-4-19 
**/ 
public class Infielder extends SoftballPlayer { 
   private double infielderFieldingAvg;
   
   /** A constructor that declares all the different variables. 
   * @param numberIn  
   * @param nameIn  
   * @param positionIn  
   * @param specializationIn  
   * @param battingAvgIn  
   * @param infielderFieldingAvgIn   
   **/ 
   public Infielder(String numberIn, String nameIn, String positionIn, 
      double specializationIn, double battingAvgIn, 
         double infielderFieldingAvgIn) {
      super(numberIn, nameIn, positionIn, specializationIn, battingAvgIn);
      infielderFieldingAvg = infielderFieldingAvgIn; 
   }  
   
   /** 
   * A method to get infielderFieldingAvg. 
   * @return infielderFieldingAvg 
   **/ 
   public double getInfielderFieldingAvg() {
      return infielderFieldingAvg; 
   } 
   
   /** 
   * A method that set fielding average. 
   * @param infielderFieldingAvgIn 
   **/ 
   public void setInfielderFieldingAvg(double infielderFieldingAvgIn) { 
      infielderFieldingAvg = infielderFieldingAvgIn;
   } 
   
   /** 
   * A method to set the rating. 
   * @return rating
   **/ 
   public double rating() { 
      return BASE_RATING * specialization * battingAvg
         * infielderFieldingAvg;
   } 
      

}