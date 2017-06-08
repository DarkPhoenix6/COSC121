/**
 * Polynomial
 * polyAdder
 * PolyAdderDriver.java
 */
package polyAdder;

/**
 * @class	PolyAdderDriver
 * @author 	Chris 
 * @date	May 31, 2017
 *
 */
public class PolyAdderDriver {

	static PolyAdder poly;
	static ReadFile input;
	static WriteFile output;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		poly = new PolyAdder();
		input = new ReadFile();
		output = new WriteFile();
		for ( int i = 0; i < 2; i++ )
		{
			//System.out.println( args[i] );
			input.openFile( args[i] );
			poly.createList( input.getPolys(), i );
			input.closeFile();
		}
		
		poly.add();
		System.out.print(poly.toString());
		String Str = poly.getResult().toString();
		
		output.openFile( args[2]);
		output.writeFile(Str);
		output.closeFile();
		
		return;
	}

}
