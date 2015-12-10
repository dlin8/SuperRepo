/*Derek Lin
  APCS1 pd5
  HW45 -- Come Together
  2015-12-10 */

public interface ListComparable {
    //adds val at end of array
    void add (Comparable newVal);
    
    //adds val at specified index, shifts other values to right to make room
    void add (int index, Comparable newVal);
    
    //removes the val at specified index, other vals shift left to fill in "empty" space
    void remove (int index);
    
    //returns _size of array
    int size();
}
