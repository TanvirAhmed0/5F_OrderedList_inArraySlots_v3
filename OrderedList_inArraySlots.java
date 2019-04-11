/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
     
    // While-style version of code
    // public int indexOf( Integer findMe) {
        // int lower = 0, upper = size() - 1;
        // while( lower <= upper ) {
            // int current = (lower + upper)/2;
            // int compared = get(current).compareTo(findMe);
            // if ( compared == 0) return current;
            // else if ( compared == 1) upper = current - 1;
            // else lower = current + 1;
        // }
        // return -1;
    // }
    
    public int indexOf( Integer findMe) {
        return recurseIndexOf( 0, size() - 1, findMe);
    }
    
    public int recurseIndexOf( int lower, int upper, Integer findMe) {
        int current = (lower + upper)/2;
        int compared = get(current).compareTo(findMe);
        if ( lower > upper ) return -1;
        else if ( compared == 0) return current;
        else if ( compared == 1) return recurseIndexOf( lower, current - 1, findMe);
        else return recurseIndexOf( current + 1, upper, findMe);
    }
    

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
