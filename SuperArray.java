/*Derek Lin
  APCS1 pd5
  HW45 -- Come Together
  2015-12-10 */

public class SuperArray implements ListComparable{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    {
	String s = "[";
	for (int i = 0; i < _size; i++) {
	    if (i == _size - 1)
		s += _data[i];
	    else 
		s += _data[i] + ",";
	}
	s += "]";
	return s;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	_data[_lastPos+1] = newVal;

	//update vars
	_lastPos++;
	_size++;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
    	if(!(index > _lastPos+1)){
	    for (int i = _lastPos; i >= index; i--){
		_data[i + 1] = _data[i];
	    }
	    //adds in newVal
	    _data[index] = newVal;
	    //update vars
	    _lastPos++;
	    _size++;
    	}
    	else{
	    System.out.println("Bad index, must be lower or equal to the right-most index + 1");
    	}
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	//shifts elements to left, each replacing one b4 it, starting from left
	for (int i = index; i < _lastPos; i++)
	    _data[i] = _data[i + 1];

	//update vars
        _lastPos--;
	_size--;
    }


    //return number of meaningful items in _data
    public int size() {
	return _size;
    }

    public int linSearch(Comparable some){
	int retInt = -1;
	for(int i = 0; i < _lastPos; i++){
	    if (
		_data[i].compareTo(some) == 0){
		retInt = i;
		return retInt;
	    }
	}
	return retInt;
    }
    public boolean isSorted(){
	int temp = 0;
	for(int i = 1; i <= _lastPos; i++){
	    temp = _data[i].compareTo(_data[i-1]);
	    System.out.println(_data[i]);
	    System.out.println(_data[i-1]);
	    System.out.println(temp);
	    System.out.println();
	    if (temp == -1){
		return false;
	    }
	}
	return true;
    }
    
    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray bad = new SuperArray();
	SuperArray good = new SuperArray();
	Rational one = new Rational(1,1);
	Rational half = new Rational(1,2);
	Rational fourth = new Rational(1,4);
	Binary two = new Binary(2);
	Binary four = new Binary(4);
	Binary eight = new Binary(8);
	Hexadecimal sixteen = new Hexadecimal(16);
	Hexadecimal thirtytwo = new Hexadecimal(32);
	Hexadecimal zero = new Hexadecimal(0);
	System.out.println(one);
	System.out.println(half);
	System.out.println(fourth);
	System.out.println(two);
	System.out.println(four);
	System.out.println(eight);
	System.out.println(sixteen);
	System.out.println(thirtytwo);
	System.out.println(zero);
	bad.add(one);
	bad.add(half);
	bad.add(fourth);
	bad.add(two);
	bad.add(four);
	bad.add(eight);
	bad.add(sixteen);
	bad.add(thirtytwo);
	bad.add(zero);
	System.out.println(bad);
	System.out.println(bad.linSearch(sixteen));
	Hexadecimal hundred = new Hexadecimal(100);
	System.out.println(bad.linSearch(hundred));
	System.out.println(bad.isSorted());
	good.add(zero);
	good.add(fourth);
	good.add(half);
	good.add(one);
	good.add(two);
	good.add(four);
	good.add(eight);
	good.add(sixteen);
	good.add(thirtytwo);
	System.out.println(good);
	System.out.println(good.isSorted());
    }//end main
		
}//end class
