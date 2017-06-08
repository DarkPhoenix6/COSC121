/**
 * Polynomial
 * polyAdder
 * WriteFile.java
 */
package polyAdder;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

/**
 * 
 * @class	WriteFile
 * @author 	Chris Fedun
 * @date	Jun 1, 2017
 *
 */
public class WriteFile implements Write {

	private Formatter output;
	


	/**
	 *  (non-Javadoc)
	 * @see polyAdder.Write#openFile(java.lang.String)
	 */
	@Override
	public void openFile(String file) {
		// TODO Auto-generated method stub
		try
		{
			output = new Formatter( new File(file));
		}
		catch ( SecurityException sE )
	      {
	         System.err.println("You do not have write access permissions for this file." );
	         System.exit( 1 ); // terminate the program
	      }
		catch ( FileNotFoundException f)
		{
			System.err.print("File Not Found, Unable to Create file, or Problems Opening the File!");
			System.exit(1); // terminate the program
		}
	}

	public void writeFile( String Str ){
		
		try
		{
			String newline = System.getProperty("line.separator");
			int a = 1;
			
			String[] result = splitString( Str );
			while ( a < result.length )
			{
				int i = Integer.valueOf(result[a++]);
				int j = Integer.valueOf(result[a++]);
				if ( a < result.length )
				{
					output.format("%d %d%s", i, j, newline);

				}
				else
				{
					output.format("%d %d", i, j);
				}
				
			}
		}
		catch ( FormatterClosedException formatterClosedException )
        {
           System.err.println( "Error writing to file." );
           return;
        } // end catch
        catch ( NoSuchElementException elementException )
        {
           System.err.println( "Invalid input. Please try again." );
           //input.nextLine(); // discard input so user can try again
        } // end catch
	}
	

	/**
	 *  (non-Javadoc)
	 * @see polyAdder.Write#closeFile()
	 */
	@Override
	public void closeFile()
    {
		if ( output != null )
		{
			output.close();
		}
    }


	
	private String[] splitString(String Str)
	{
		
		String[] P = Str.split("\\s");
		String R = null;
		String U = null;
		for (String q: Str.split("x\\*\\*"))
		{
			if (R == null)
			{
				R = new String(q + " " );
			}
			else
			{
				R += q + " ";
			}
		}

		P = R.split("-\\s");
		for ( int l = 0; l < P.length; l++ )
		{
			if ( l + 1 < P.length )
			{
				if ( U == null )
				{
					U = new String( P[l] + "-");
				}
				else
				{
					U += P[l] + "-";
				}
			}
			else
			{
				if ( U == null )
				{
					U = new String( P[l]);
				}
				else
				{
					U += P[l];
				}
			}
		}
		
		String resultString = null;
		for ( String v: U.split("\\+ "))
		{
			if ( resultString == null )
			{
				resultString = new String(v);
			}
			else
			{
				resultString += v;
			}
		}
		return resultString.split("\\s");
	}
}
