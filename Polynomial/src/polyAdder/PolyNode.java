/**
 * Polynomial
 * polyAdder
 * PolyNode.java
 */
package polyAdder;

/**
 * @class	PolyNode
 * @author 	Chris 
 * @date	May 31, 2017
 *
 */
public class PolyNode {

	private int coefficient;
	private int exponent;
	private PolyNode next;
	
	
	
	
	/**
	 * 
	 */
	public PolyNode() {
		this.coefficient = 0;
		this.exponent = 0;
		this.next = null;
	}
	
	/**
	 * @param pL
	 */
	public PolyNode(PolyNode PL) {
		// TODO Auto-generated constructor stub
		this.coefficient = PL.getCoefficient();
		this.exponent = PL.getExponent();
		this.next = PL.getNext();
	}
	
	/**
	 * @param coefficient
	 * @param exponent
	 */
	public PolyNode(int coefficient, int exponent) {
		this.coefficient = coefficient;
		this.exponent = exponent;
		this.next = null;
	}
	
	/**
	 * @param coefficient
	 * @param exponent
	 * @param next
	 */
	public PolyNode(int coefficient, int exponent, PolyNode next) {
		this.coefficient = coefficient;
		this.exponent = exponent;
		this.next = next;
	}

	
	// Accessors
	


	/**
	 * @return the coefficient
	 */
	public int getCoefficient() 
	{
		return coefficient;
	}
	
	/**
	 * @return the exponent
	 */
	public int getExponent() 
	{
		return exponent;
	}
	
	/**
	 * @return the next
	 */
	public PolyNode getNext() 
	{
		return next;
	}
	
	
	
	// Mutators
	
	/**
	 * @param coefficient the coefficient to set
	 */
	public void setCoefficient(int coefficient) 
	{
		this.coefficient = coefficient;
	}
	
	/**
	 * @param exponent the exponent to set
	 */
	public void setExponent(int exponent) 
	{
		this.exponent = exponent;
	}
	
	/**
	 * @param next the next to set
	 */
	public void setNext(PolyNode next) 
	{
		this.next = next;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString()
	{
		return String.format("%dx**%d", getPrintCoefficient(), getExponent() );
	}

	/**
	 * @return
	 */
	private int getPrintCoefficient() {
		// TODO Auto-generated method stub
		if ( getCoefficient() < 0 )
		{
			return 0 - getCoefficient();
		}
		else
		{
			return getCoefficient();
		}
	}
	
}
