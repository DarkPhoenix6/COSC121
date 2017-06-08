/**
 * Polynomial
 * polyAdder
 * ReadFile.java
 */
package polyAdder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.Scanner;

/**
 * @class	ReadFile
 * @author 	Chris Fedun
 * @date	Jun 1, 2017
 *
 */
public class ReadFile implements Read {

	private Scanner input;
	
	/**
	 *  (non-Javadoc)
	 * @see polyAdder.Read#openFile(java.lang.String)
	 */
	@Override
	public void openFile( String file )
	{
		try 
		{
			input = new Scanner( new File(file) );
		}
		catch ( FileNotFoundException f)
		{
			System.err.print("File Not Found!");
			System.exit(1);
		}
	}
	
	public String getPolys()
	{
		String Str = new String();
		try
		{
			while ( input.hasNextLine() )
			{
				Str += input.nextLine();
				Str += " ";
			}
			
			
		}
		catch ( NoSuchElementException NSEE )
		{
			System.err.print("File Not Readable!");
			input.close();
			System.exit(1);
		}
		catch ( IllegalStateException ISE )
		{
			System.err.print("Error Reading The File!");
			System.exit(1);
		}
		
		return Str;
		
	}
	
	/**
	 *  (non-Javadoc)
	 * @see polyAdder.Read#closeFile()
	 */
	@Override
	public void closeFile()
	{
		if ( input != null )
		{
			input.close();
		}
	}

	
}
