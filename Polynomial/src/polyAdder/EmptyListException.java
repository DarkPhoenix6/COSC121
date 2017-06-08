/**
 * Polynomial
 * polyAdder
 * EmptyListException.java
 */
package polyAdder;

/**
 * @class	EmptyListException
 * @author 	Chris Fedun
 * @date	May 31, 2017
 *
 */
public class EmptyListException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3059798816083929402L;


	public EmptyListException()
	{
		
		this("The List(s)");
	}
	
	public EmptyListException( String name )
	{
		super( name + " is/are Empty!");
	}

	
}
