import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  YOUR NAME (you@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version TODAY
 *
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      if (comp == null || coll == null) {
         throw new IllegalArgumentException();
      } 
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
   
      Iterator<T> iteColl = coll.iterator();
      T min = iteColl.next();
      while (iteColl.hasNext()) { 
         T check = iteColl.next();
         if (comp.compare(check, min) < 0) {
            min = check;
         } 
      }
      return min;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (comp == null || coll == null) {
         throw new IllegalArgumentException(); 
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException(); 
      }
   
      Iterator<T> iteColl = coll.iterator(); 
      T max = iteColl.next(); 
      while (iteColl.hasNext()) {
         T check = iteColl.next();
         if (comp.compare(check, max) > 0) {
            max = check;
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      if (comp == null || coll == null) {
         throw new IllegalArgumentException(); 
      }
      if (coll.isEmpty() || k < 1 || k > coll.size()) {
         throw new NoSuchElementException(); 
      }
   
      ArrayList<T> array = new ArrayList<T>();
      Iterator<T> itrColl = coll.iterator();
      while (itrColl.hasNext()) {
         array.add(itrColl.next()); 
      } 
   
      java.util.Collections.sort(array, comp); 
   
      if (k == 1) { 
         return array.get(0);
      }
   
      int minimum = 1; 
      T check = array.get(0);
      T kmin = null; 
      for (int i = 1; i < array.size(); i++) {
         if (!array.get(i).equals(check)) {
            minimum++;
            if (k == minimum) {
               kmin = array.get(i);
            }
         }
         check = array.get(i);  
      } 
   
      if (k > minimum) {
         throw new NoSuchElementException(); 
      }
      return kmin;
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (comp == null || coll == null) {
         throw new IllegalArgumentException(); 
      }
      if (coll.isEmpty() || k < 1 || k > coll.size()) {
         throw new NoSuchElementException(); 
      }
   
      ArrayList<T> array = new ArrayList<T>();
      Iterator<T> itrColl = coll.iterator();
      while (itrColl.hasNext()) {
         array.add(itrColl.next()); 
      } 
   
      java.util.Collections.sort(array, comp); 
   
      if (k == 1) { 
         return array.get(array.size() - 1);
      }
   
      int maximum = 1; 
      T check = array.get(array.size() - 1);
      T kmax = null; 
      for (int i = array.size() - 2; i >= 0; i--) {
         if (!array.get(i).equals(check)) {
            maximum++;
            if (k == maximum) {
               kmax = array.get(i);
            }
         }
         check = array.get(i);  
      } 
   
      if (k > maximum) {
         throw new NoSuchElementException(); 
      }
      return kmax;
   }



   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
      if (comp == null || coll == null) {
         throw new IllegalArgumentException(); 
      }
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
   
      Iterator<T> itrColl = coll.iterator();
      ArrayList<T> range = new ArrayList<T>(); 
      while (itrColl.hasNext()) { 
         T check = itrColl.next();
         if (comp.compare(check, low) >= 0 && comp.compare(check, high) <= 0) {
            range.add(check); 
         }
      }
   
      if (range.isEmpty()) {
         throw new NoSuchElementException();
      }
      return range;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      if (comp == null || coll == null) { 
         throw new IllegalArgumentException();
      } 
      if (coll.isEmpty()) { 
         throw new NoSuchElementException(); 
      } 
      T ceiling = null; 
      Iterator<T> itrColl = coll.iterator(); 
      boolean found = false; 
      while (itrColl.hasNext()) { 
         T check = itrColl.next();
         if (!found && comp.compare(check, key) >= 0) {
            ceiling = check;
            found = true;
         }
         
         else if (comp.compare(check,key) >= 0 && comp.compare(check, ceiling) <= 0) {
            ceiling = check; 
         
         }
      } 
      if (!found) {
         throw new NoSuchElementException(); 
      }
      return ceiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if (comp == null || coll == null) {
         throw new IllegalArgumentException();
      }
   
      if (coll.isEmpty()) { 
         throw new NoSuchElementException(); 
      } 
      T floor = null; 
      Iterator<T> itrColl = coll.iterator(); 
      boolean found = false; 
      while (itrColl.hasNext()) { 
         T check = itrColl.next();
         if (!found && comp.compare(check, key) <= 0) {
            floor = check;
            found = true;
         }
         
         else if (comp.compare(check,key) <= 0 && comp.compare(check, floor) >= 0) {
            floor = check; 
         
         }
      } 
      if (!found) {
         throw new NoSuchElementException(); 
      }
      return floor;
   }
}
