
public final class Poly {
	/**
	 * Private class to define the structure of the array (A single term)
	 */
	private static final class Term{
		int deg;
		int coeff;
		
		private Term(int deg, int coeff) {
			this.deg = deg;
			this.coeff = coeff;
		}
		
		/** Compare the two terms
		 * @param t1 input term
		 * @param t2 input term
		 * @return true if two terms are equal
		 */
		private static boolean compareTo(Term t1, Term t2) {
			return (t1.deg==t2.deg) && (t1.coeff==t2.coeff)? true: false;
		}
		
	}
	private final Term polynom[];
	
	/** Constructor to initialize object from user end.
	 * @param inputArray 1D array with index represent degree
	 */
	public Poly(int[] inputArray) {
		polynom = init(inputArray);
	}
	
	/** Constructor with input as Term[]
	 * @param polynom Term object array
	 */
	private Poly(Term polynom[]) {
		this.polynom = polynom;
	}
	
	/** This is to convert the input data to term structure and store it in term array
	 * @param inputArray input integer array
	 * @return the Term array
	 */
	private Term[] init(int[] inputArray) {
		int count=0;
		for(int i=0; i<inputArray.length;i++) {
			if(inputArray[i]!=0) count++;
		}
		
		Term[] tempArray = new Term[count];
		
		for(int i=0,j=0;i<inputArray.length && j<count;i++) {
			if(inputArray[i]==0) continue;
			tempArray[j] = new Term(i,inputArray[i]); /* (degree,coefficient) */
			j++;
		}
		return tempArray;
	}
	
	
	/**
	 * @return the length of the polynomial array
	 */
	public int size() {
		return polynom.length;
	}
	
	/** Evaluate the polynomial on the given input
	 * @param value double value
	 * @return the value of the polynomial for the given value of the variable
	 */
	public double evaluate(double value) {
		double sum = 0.0;
		Term term;
		for(int i=0; i<size();i++) {
			term = polynom[i];
			sum += term.coeff * Math.pow(value,term.deg);
		}
		return sum;
	}
	
	/** Addition of the two input polynomial
	 * @param p1 input polynomial
	 * @param p2 input polynomial
	 * @return the sum of the polynomials p1 and p2
	 */
	public static Poly addPoly(Poly p1, Poly p2) {
		Term term1, term2;
		int len = countTotal(p1.polynom, p2.polynom);
		
		Term[] poly = new Term[len];
		int k = 0, i = 0, j = 0;
		
		while (i < p1.size() && j < p2.size()) {
			term1 = p1.polynom[i];
			term2 = p2.polynom[j];

			if (term1.deg == term2.deg) {
				poly[k] = new Term(term1.deg, term1.coeff + term2.coeff);
				i++;
				j++;
			} else if (term1.deg < term2.deg) {
				poly[k] = new Term(term1.deg, term1.coeff);
				i++;
			} else {
				poly[k] = new Term(term2.deg, term2.coeff);
				j++;
			}
			k++;

		}

		while (j < p2.size()) {
			System.out.println(j);
			term2 = p2.polynom[j];
			poly[k] = new Term(term2.deg, term2.coeff);
			j++;
			k++;
		}

		while (i < p1.size()) {
			term1 = p1.polynom[i];
			poly[k] = new Term(term1.deg, term1.coeff);
			i++;
			k++;
		}
			 
		return new Poly(poly);
	}
	
	/**
	 * Method to print the polynomial
	 */
	public void show() {
		for(int i=0;i<this.size();i++) {
			
			if(i<this.size()-1) {
				System.out.print(polynom[i].coeff +"x^"+polynom[i].deg + " + ");
			} else {
				System.out.print(polynom[i].coeff +"x^"+polynom[i].deg);
			}
		}
	}

	
	/**
	 * Sub method to count the intersected degree of the polynomials 
	 * @param p1 input 
	 * @param p2 input
	 * @return count of degree
	 */
	private static int countTotal(Term[] p1, Term[] p2) {
		int count=0;
		for(int i=0;i<p1.length;i++)
		{
			boolean flag = true;
			for(int j=i+1;j<p2.length;j++) {
				if(p1[i].deg==p2[j].deg) {
						count++;
						break;
				}
			}
			if(flag)
				count++;
		}
		return count;
	}
	
	/** Multiplication of two input polynomial, assumes highest degree of input polynomial as 5.
	 * @param p1 input polynomial
	 * @param p2 input polynomial
	 * @return the product of polynomials p1 and p2
	 */
	public static Poly multiplyPoly(Poly p1, Poly p2) {
		Term term1, term2;
		int len = p1.size() + p2.size() + 1;
		
		int coff[] = new int[len]; 
		
		for(int i=0; i<p1.size(); i++) {
			term1 = p1.polynom[i];
			for(int j=0; j<p2.size(); j++) {
				term2 = p2.polynom[j];
				// i+j to add same degree coefficient
				coff[i+j] += term1.coeff*term2.coeff;
			}
		}
		
		return new Poly(coff);
	}
	
	/**
	 * @return the degree of the polynomial
	 */
	public int degree() {
		return polynom[size()-1].deg;
	}
	
	/** Compare two polynomials
	 * @param p1 input Polynomial
	 * @param p2 input Polynomial
	 * @return boolean true of both are same
	 */
	public static boolean compare(Poly p1, Poly p2) {
		boolean b= true;
		if(p1.size()!=p2.size()) {
			b = false;	
		}else {
			Term []term1= p1.polynom;
			Term []term2= p2.polynom;
			for(int i=0;i<p1.size();i++) {
				if(!Term.compareTo(term1[i],term2[i])) {
					b= false;
					break;
				}
			}
		}
		return b;
	}
	
	
	/** Getter to get term[] array of polynomial
	 * @return Term[] array
	 */
	public Term[] getPolynom() {
		return polynom;
	}

}
		
