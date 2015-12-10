/* Derek Lin
   APCS1 pd5
   HW45 -- Come Together
   2015-12-10 */

public class Binary implements Comparable{
    public int _decNum;
    private String _binNum;

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() {
	_decNum = 0;
	_binNum = "0";
    }
    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bit
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n);
    }

    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_decNum = binToDec(s);
	_binNum = s;
    }

    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() {
	return _binNum;
    }

    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	int remainder = 0;
	int quotient = n;
	String retStr = "";
	while(quotient!=0){
	    remainder = quotient%2;
	    quotient = quotient/2;
	    retStr = remainder + retStr;
	}
	return retStr;
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) {
	String retStr = "";
	if (n == 1){
	    return "1";
	}
	else{
	    retStr = Integer.toString(n%2);
	    n = n/2;
	    return decToBinR(n) + retStr;
	}
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	int retInt = 0;
	for(int i = s.length(); i != 0; i--){
	    retInt += Integer.parseInt(s.substring(i-1, i)) * Math.pow(2, s.length() - i);
	}
	return retInt;
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) {
	int retInt = 0;
	if(s.length() == 1){
	    return Integer.parseInt(s);
	}
	else{
	    retInt = Integer.parseInt(s.substring(0,1)) * (int)Math.pow(2, s.length() - 1);
	    s = s.substring(1);
	    return retInt + binToDecR(s);
	}
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) {
	if (other instanceof Binary){
	    if( other == this ){
		return true;
	    }
	    else if(this._binNum.equals( ((Binary)other)._binNum) ){
		return true;
	    }
	}
	return false;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other) {
	if (other instanceof Comparable){
	    if(other == null || this == null){
		throw new NullPointerException();
	    }
	    if(other instanceof Binary){
		if (this._decNum == ((Binary)other)._decNum){
		    return 0;
		}
		else if (this._decNum < ((Binary)other)._decNum){
		    return -1;
		}
		else{
		    return 1;
		}
	    }
	    if(other instanceof Hexadecimal){
		if (this._decNum == ((Hexadecimal)other)._decNum){
		    return 0;
		}
		else if (this._decNum < ((Hexadecimal)other)._decNum){
		    return -1;
		}
		else{
		    return 1;
		}
	    }		
	    if(other instanceof Rational){
		if ((double)this._decNum == ((Rational)other).floatValue()){
		    return 0;
		}
		else if ((double)this._decNum < ((Rational)other).floatValue()){
		    return -1;
		}
		else{
		    return 1;
		}
	    }
	}
	else{
	    throw new ClassCastException();
	}
	return -2;
    }


    //main method for testing
    public static void main( String[] args ) {
	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);
	
	System.out.println("\ntoString()...");
	System.out.println("b1.toString(), 5 --> 101");
	System.out.println( b1 );
	System.out.println("b1.toString(), 5 --> 101");
	System.out.println( b2 );
	System.out.println("b1.toString(), 5 --> 101");
	System.out.println( b3 );
	System.out.println("b1.toString(), 7 --> 111");
	System.out.println( b4 );

	System.out.println("\ndecToBin and binToDec...");
	System.out.println("decToBin(b1._decNum, should be 101");
	System.out.println(decToBin(b1._decNum));
	System.out.println("decToBinR(b1._decNum, should be 101");
	System.out.println(decToBinR(b1._decNum));
	System.out.println("binToDec(b1._binNum, should be 5");
	System.out.println(binToDec(b1._binNum));
	System.out.println("binToDecR(b1._binNum, should be 5");
	System.out.println(binToDecR(b1._binNum));

	System.out.println( "\n==..." );
	System.out.println("b1 == b2, should be false");
	System.out.println( b1 == b2 ); //should be false
	System.out.println("b1 == b3, should be true");
	System.out.println( b1 == b3 ); //should be true
	
	System.out.println( "\n.equals()..." );
	
	System.out.println("b1.equals(b2), should be true");
	System.out.println( b1.equals(b2) ); //should be true
	
	System.out.println("b1.equals(b3), should be true");
	System.out.println( b1.equals(b3) ); //should be true
	
	System.out.println("b3.equals(b1), should be true");
	System.out.println( b3.equals(b1) ); //should be true
	
	System.out.println("b4.equals(b2), should be false");
	System.out.println( b4.equals(b2) ); //should be false
	
	System.out.println("b1.equals(b4), should be false");
	System.out.println( b1.equals(b4) ); //should be false

	
	System.out.println( "\n.compareTo..." );
	System.out.println("b1.compareTo(b2), should be 0");
	System.out.println( b1.compareTo(b2) ); //should be 0
	
	System.out.println("b1.compareTo(b3), should be 0");
	System.out.println( b1.compareTo(b3) ); //should be 0
	
	System.out.println("b1.compareTo(b4), should be neg");
	System.out.println( b1.compareTo(b4) ); //should be neg
	
	System.out.println("b4.compareTo(b1), should be pos");
	System.out.println( b4.compareTo(b1) ); //should be pos

	Integer i = new Integer(5);
	System.out.println(b4.compareTo(i));
	
    }//end main()

} //end class
