//Team Panda - Jordan Louie, Derek Lin
//APCS1 pd5
//HW42 -- Array of Titanium
//2015-12-07

public class SuperArray implements ListInt{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor ¡V initializes 10-item array
    public SuperArray() 
    { 
	_data = new int[10];
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
	
	/*String foo = "[";
	  for( int i = 0; i < _size; i++ ) {
	  foo += _data[i] + ",";
	  }
	  //shave off trailing comma
	  if ( foo.length() > 1 )
	  foo = foo.substring( 0, foo.length()-1 );
	  foo += "]";
	  return foo;*/
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) 
    { 
 	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) {
	_data[_lastPos+1] = newVal;

	//update vars
	_lastPos++;
	_size++;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) {
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


    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

	System.out.println("How big is mayfield currently?:");
	System.out.println(mayfield.size());
	  
	  
	ListInt panda = new SuperArray();
	System.out.println("Printing empty SuperArray panda...");
	System.out.println(panda);

	panda.add(5);
	panda.add(4);
	panda.add(3);
	panda.add(2);
	panda.add(1);

	System.out.println("Printing populated SuperArray panda...");
	System.out.println(panda);

	panda.remove(3);
	System.out.println("Printing SuperArray panda post-remove...");
	System.out.println(panda);
	panda.remove(3);
	System.out.println("Printing SuperArray panda post-remove...");
	System.out.println(panda);

	panda.add(3,99);
	System.out.println("Printing SuperArray panda post-insert...");
	System.out.println(panda);
	panda.add(2,88);
	System.out.println("Printing SuperArray panda post-insert...");
	System.out.println(panda);
	panda.add(1,77);
	System.out.println("Printing SuperArray panda post-insert...");
	System.out.println(panda);
	
	System.out.println("How big is panda currently?:");
	System.out.println(panda.size());
	
	panda.add(7,66);
	System.out.println("Printing SuperArray panda post-insert...");
	System.out.println(panda);

	System.out.println("How big is panda currently?:");
	System.out.println(panda.size());
    }//end main
		
}//end class
