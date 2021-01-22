import java.text.DecimalFormat; 
/** 
* An abstract class that holds player data.
*
* Project_09 
* @author Carlton Schmieder
* @version 4-4-19 
**/ 
public abstract class SoftballPlayer {
   protected String number; 
   protected String name; 
   protected String position; 
   protected double specialization; 
   protected double battingAvg; 
   protected static int count = 0;
   /** Static final for Base Rating. **/
   public static final int BASE_RATING = 10; 
   
   /** 
   * A constructor that declares numner, name, position, specialization,
      battingAvg.
   * @param numberIn  
   * @param nameIn  
   * @param positionIn  
   * @param specializationIn  
   * @param battingAvgIn 
   **/
   public SoftballPlayer(String numberIn, String nameIn, String positionIn,
      double specializationIn, double battingAvgIn) {
      number = numberIn; 
      name = nameIn; 
      position = positionIn; 
      specialization = specializationIn; 
      battingAvg = battingAvgIn; 
      count++;
   } 
   
   /** 
   * A method to getNumber. 
   * @return number 
   **/
   public String getNumber() {
      return number; 
   }
   
   /**
   * A method to set the number. 
   * @param numberIn  
   **/
   public void setNumber(String numberIn) { 
      number = numberIn;
   }
   
   /** 
   * A method the gets name. 
   * @return name 
   **/ 
   public String getName() { 
      return name;
   } 
   
   /** 
   * A method to set name. 
   * @param nameIn   
   **/ 
   public void setName(String nameIn) {  
      name = nameIn; 
   } 
   
   /** 
   * A method to get position. 
   * @return position 
   **/ 
   public String getPosition() { 
      return position; 
   } 
   
   /**
   * A method to set the position. 
   * @param positionIn  
   **/ 
   public void setPosition(String positionIn) {
      position = positionIn; 
   } 
   
   /** 
   * A method to get the batting average. 
   * @return battingAvg 
   **/ 
   public double getBattingAvg() { 
      return battingAvg; 
   }
   
   /** 
   * A method to set battingAvg. 
   * @param battingAvgIn   
   **/ 
   public void setBattingAvg(double battingAvgIn) { 
      battingAvg = battingAvgIn; 
   }
   
   /** 
   * A method to get Specialization. 
   * @return specialization 
   **/ 
   public double getSpecializationFactor() { 
      return specialization;
   }
   
   /** 
   * A method to set specialization. 
   * @param specializationIn     
   **/ 
   public void setSpecializationFactor(double specializationIn) { 
      specialization = specializationIn; 
   }
   
   /** 
   * A method to get count. 
   * @return count
   **/ 
   public static int getCount() { 
      return count; 
   }
   
   /** 
   * Resets the count to zero. 
   **/ 
   public static void resetCount() {
      count = 0; 
   }
   
   /** 
   * A method that returns batting avg. 
   * @return battingAvg
   **/ 
   public String stats() { 
      DecimalFormat df = new DecimalFormat(".000"); 
      String stats;
      stats = df.format(getBattingAvg()); 
      return stats; 
   } 
   
   /** 
   * A method to print string. 
   * @return String 
   **/ 
   public String toString() { 
      DecimalFormat df = new DecimalFormat("0.000"); 
      String result; 
      result = getNumber() + " " + getName() + " (" 
         + getPosition() + ") " + stats() + "\n";
      result += "Specialization Factor: " + getSpecializationFactor() 
         + " (" + this.getClass() + ") Rating: " + df.format(rating());
      return result;
   }
   
   /**
   * An abstract method that returns rating.
   * @return rating
   **/
   public abstract double rating();
      
      
      
      
      
      
      
      
      

}