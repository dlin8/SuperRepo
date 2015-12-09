/*
  Team Pandas -- Jordan Louie, Derek Lin
  APCS1 pd5
  HW41 -- In America, the Driver Sits on the Left
  2015 - 12 - 04
*/

public class Rational implements Comparable{

    //Instance variables for the numerator and denominator
    private int num;
    private int den;
    //Default constructor (no parameters)
    //Creates a new Rational with the value of 0/1
    public Rational(){
        num = 0;
        den = 1;
    }
    // Constructor
    // takes 2 parameters, numerator + denominator
    // if an invalid denominator is attempted
    // should print a message and set the number to 0/1
    public Rational(int a, int b){
	if (a == 0 && b == 0) {
	    num = a;
	    den = b;
	}
	else if (b == 0){
	    num = 0;
	    den = 1;
	}
	else {
	    num = a;
	    den = b;
	}
    }
    // toString
    //returns a string representation of the rational number
    public String toString(){
	return ( num + "/" + den );
    }
    //floatValue
    //Returns a floating point value of the number
    public double floatValue(){
	return 1. * num/den;
    }
    //multiply
    //Takes Rational object as parameter and multiplies by this Rational object
    //Does not return value
    public void multiply(Rational jordans){
	num *= jordans.num;
	den *= jordans.den;
    }
    //divide
    //Takes Rational object as parameter and divides by this Rational object
    //Does not return value
    public void divide(Rational aleks){
	if (aleks.num == 0){
	    System.out.print( "error, divide by zero");
	}
	else {
	    num *= aleks.den;
	    den *= aleks.num;
	}
    }

    //add
    //Takes one rational object and adds it to current rational object
    public void add(Rational jordans) {
	if (den == 0) 
	    System.out.println("error, zero denominator");
	else if (den == jordans.den){
	    num += jordans.num;
	    den = jordans.den;} //base case
	else {
	    jordans.reduce();
	    Rational temp = new Rational (num, den);
	    add(temp);
	} //finding gcd and using recursion
    }

    //subtract
    //Works the same as add, except the operation is subtraction
    public void subtract(Rational jordans) {
	if (den == jordans.den)
	    num -= jordans.num; // base case
	// denominators are same
	else {
	    jordans.reduce();
	    Rational temp = new Rational (num, den);
	    subtract(temp);
	} //finding gcd and using recursion
    }


    // gcdEW: finding gcd with euclidean loop

    public static int gcdEW(int a, int b) {
        while (!(a==0 || b==0) ) { //condition for the while loop to prevent infinite loop
            if (a>b) {
                a-=b;
            }
            else {
                b-=a;
            } //making sure the right integers are subtracted in the Euclidean Algorithm
        }
        if (a==0) {
            return b;
        }
        else {
            return a; }
    } //returning GCD

    // reduce
    // Changes this Rational to one in reduced form (should use gcd)
    public void reduce() {
	int reduction = gcdEW( num, den);
	num = num / reduction;
	den = den / reduction;
    }

    //compareTo
    /*Takes a Rational as a parameter and compares it to the calling object
      return 0, if both equal
      return 1 if calling num > param
      return -1 if calling num < param*/
    public int compareTo(Object o) {
	    int i = 0;
	    if(o instanceof Rational){
	        Rational a = new Rational(this.num, this.den);
	        Rational b = new Rational( ((Rational)o).num, ((Rational)o).den ); //Typecasting Object o to a Rational so that num and den can be called.
	        a.reduce();
	        b.reduce();
	        if(a.num * b.den == b.num * a.den) {
	            i = 0;
	            return i;
	        }
	        else if(a.num * b.den > b.num * a.den){
	            i = 1;
	            return i;
	        }
	        else{
	            i = -1;
	            return i;
	        }
	    }
	    i = -2;
	    System.out.println("Invalid parameter, must be a Rational.");
	    return i;
    }
    
    //equals method
    //checks if the two rationals are equal after reduction/simplification
    public boolean equals(Object o) {
	if(o instanceof Rational){
	    Rational a = new Rational(this.num, this.den);
	    Rational b = new Rational( ((Rational)o).num, ((Rational)o).den);
	    a.reduce();
	    b.reduce();
	    return (a.num == b.num && a.den == b.den);
	}
	return false;
    }

    public static void main(String[] args){

	//new rational numbers
	Rational basic = new Rational(1,1); // 1/1
	Rational test = new Rational(2,3); // 2/3
	Rational tester = new Rational(1,2); // 1/2
	Rational testing = new Rational(5,0); // 5/0 - invalid - 0/1
	Rational testin = new Rational (0,0); // 0/0 - works
	Rational testor = new Rational (3,9); // 3/9
	Rational testa = new Rational(2,4); //2/4
	Integer huh = new Integer(3);

	//testing toString
	System.out.println( basic.toString() );
	System.out.println( test.toString() );
	System.out.println( tester.toString() );
	System.out.println( testing.toString() );
	System.out.println( testin.toString() );
	System.out.println("\n" );

	//testing multiply

	System.out.println( "testing multiply" );

	basic.multiply(test);
	System.out.println( basic ); //should print out 2/3
	basic.multiply(testing);
	System.out.println("\n" );

	//testing divide

	System.out.println( "testing divide" );

	test.divide(tester);
	System.out.println( test );
	basic.divide(test);
	System.out.println( basic );

	//testing add

	System.out.println( "testing add" );

	basic.add(test);
	System.out.println( basic );
	test.add(basic);
	System.out.println( test );
	testin.add(testing);
	System.out.println(testin);

	//testing reduce

	System.out.println( "testing reduce" );

	basic.reduce(); //
	System.out.println( basic );
	testor.reduce();
	System.out.println( testor );

	//Testing compareTo
	System.out.println("testing compareTo");
	System.out.println(tester.compareTo(testa)); //should be 0
	System.out.println(test.compareTo(tester)); //should be 1
	System.out.println(tester.compareTo(test)); //should be -1
	
	//Testing equals
	System.out.println("Testing equals");
	System.out.println(tester.equals(testa)); //should be true
	System.out.println(testa.equals(tester)); //should be true
	System.out.println(testing.equals(tester)); //should be false
	System.out.println(huh.equals(tester)); //should be false //Overwritten equals() belongs only to Rational class.
	System.out.println(tester.equals(huh)); //should be false
    }

}