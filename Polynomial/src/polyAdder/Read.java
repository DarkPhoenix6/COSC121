/**
 * Polynomial
 * polyAdder
 * Read.java
 */
package polyAdder;

/**
 * @class	Read
 * @author 	Chris Fedun 
 * @date	Jun 1, 2017
 *
 */
public interface Read {


	/**
	 * @Purpose Open the file for Reading/Writing
	 * @param file
	 */
	public void openFile( String file );
	/**
	 * @Purpose To Close the file after Reading/Writing
	 */
	public void closeFile();
}
