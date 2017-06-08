import java.util.Scanner;

//	Name:		 	Matrix.java
//	Author:			Chris Fedun 10/05/2017
//	Description:	Class of type Matrix
//	Instructor:		Arthur Boehm
/**
 * @category	Class of type Matrix
 * @FileName 	Matrix.java
 * @author		Chris Fedun 10/05/2017
 */
public class Matrix 
{
	private static char nameCount = 'a';
	private char MatrixName;
	private double[][] elem;
	private int num_rows;
	private int num_cols;
	private Scanner myscan;
	
	/**
	 * 
	 */
	public Matrix( )
	{
		
		myscan = new Scanner( System.in );
		System.out.println( "Please enter the number of rows: " );
		num_rows = myscan.nextInt();
		System.out.println( "Please enter the number of columns: " );
		num_cols = myscan.nextInt();
		elem = new double[getNRows()][getNCols()];
		
		for ( int i = 0; i < getNRows(); i++ )
		{
			for ( int j = 0; j < getNCols(); j++ )
			{
				//Initialize each element via user input
				System.out.printf( "Please enter the value for row %d column %d:\n", i, j );
				setElement( i, j, myscan.nextDouble() );
			}
		}		
		MatrixName = nameCount++;
	}
	
	/**
	 * 
	 * @param rows
	 * @param cols
	 */
	public Matrix( int rows, int cols )
	{
		elem = new double[rows][cols];
		num_rows = rows;
		num_cols = cols;
		for ( int i = 0; i < getNRows(); i++ )
		{
			for ( int j = 0; j < getNCols(); j++ )
			{
				//Initialize the Matrix to 0
				setElement( i, j, 0 );
				//elem[i][j] = 0;
			}
		}		
		setMatrixName( nameCount++ );
	}
	
	/**
	 * 
	 * @param B
	 * @return The product of the Matrices.
	 */
	public Matrix multiply ( Matrix B )
	{
		if ( canMultipy( B ) == true )
		{
			int m = 0;
			int p = 0;
			int n = 0;
			m = this.getNRows();
			p = this.getNCols();
			n = B.getNCols();
			System.out.println( m + " " + n + " " + p );
			Matrix C = new Matrix( m, n );
			//Matrix A( m, p ) * Matrix B( p, n) == Matrix C( m, n )
			for ( int i = 0; i < m; i++ )
			{
				for ( int j = 0; j < n; j++ )
				{	
					for ( int k = 0; k < p; k++ )
					{
						C.setElement( i, j, C.getElement( i, j ) + B.getElement( k, j ) * this.getElement( i, k ) );
					}
				}
				
			}
			return C;
		}
		else
		{
			System.out.println( "The Matrices are incompatible for multiplication!" );
			Matrix C = null;
			return C;
		}
		
	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return The product of the Matrices.
	 */
	public static Matrix multiply( Matrix A, Matrix B )
	{
		if ( canMultiply( A, B ) == true )
		{
			int m = 0;
			int p = 0;
			int n = 0;
			m = A.getNRows();
			p = A.getNCols();
			n = B.getNCols();
			Matrix C = new Matrix( m, n );
			//Matrix A( m, p ) * Matrix B( p, n) == Matrix C( m, n )
			for ( int i = 0; i < m; i++ )
			{
				for ( int j = 0; j < n; j++ )
				{	
					for ( int k = 0; k < p; k++ )
					{
						C.setElement( i, j, C.getElement( i, j ) + A.getElement( i, k ) * B.getElement( k, j ) );
					}
				}
				
			}
			return C;
		}
		else
		{
			System.out.println( "The Matrices are incompatible for multiplication!" );
			Matrix C = null;
			return C;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return The sum of the matrices.
	 */
	public static Matrix add( Matrix A, Matrix B )
	{
		if ( canAdd( A, B ) == true )
		{
			Matrix C = new Matrix( A.getNRows(), A.getNCols() );
			for ( int i = 0; i < A.getNRows(); i++ )
			{
				for ( int j = 0; j < A.getNCols(); j++ )
				{
					C.setElement( i, j, A.getElement( i, j ) + B.getElement( i, j ) );
				}
			}
			return C;
		}
		else
		{
			System.out.println( "The Matrices are NOT the same shape!" );
			Matrix C = null;
			return C;
		}
	}

	/**
	 * 
	 * @param B
	 * @return The sum of the matrices.
	 */
	public Matrix add( Matrix B )
	{
		if ( canAdd( B ) == true )
		{	
			Matrix C = new Matrix( getNRows(), getNCols() );
			for ( int i = 0; i < getNRows(); i++ )
			{
				for ( int j = 0; j < getNCols(); j++ )
				{
					C.setElement( i, j, this.getElement( i, j ) + B.getElement( i, j ) );
				}
			}
			return C;
		}
		else
		{
			System.out.println( "The Matrices are NOT the same shape!" );
			Matrix C = null;
			return C;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return The difference of the matrices.
	 */
	public static Matrix subtract( Matrix A, Matrix B )
	{
		if ( canSub( A, B ) == true )
		{
			Matrix C = new Matrix( A.getNRows(), A.getNCols() );
			for ( int i = 0; i < A.getNRows(); i++ )
			{
				for ( int j = 0; j < A.getNCols(); j++ )
				{
					C.setElement( i, j, A.getElement( i, j ) - B.getElement( i, j ) );
				}
			}
			return C;
		}
		else
		{
			System.out.println( "The Matrices are NOT the same shape!" );
			Matrix C = null;
			return C;
		}
	}

	/**
	 * 
	 * @param B
	 * @return
	 */
	public Matrix subtract( Matrix B )
	{
		if ( canSub( B ) == true )
		{	
			Matrix C = new Matrix( getNRows(), getNCols() );
			for ( int i = 0; i < getNRows(); i++ )
			{
				for ( int j = 0; j < getNCols(); j++ )
				{
					C.setElement( i, j, this.getElement( i, j ) - B.getElement( i, j ) );
				}
			}
			return C;
		}
		else
		{
			System.out.println( "The Matrices are NOT the same shape!" );
			Matrix C = null;
			return C;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */
	public static Matrix transpose( Matrix A )
	{
		Matrix B = new Matrix( A.getNCols(), A.getNRows() );
		for ( int i = 0; i < A.getNRows(); i++ )
		{
			for ( int j = 0; j < A.getNCols(); j++ )
			{
				B.setElement( j, i, A.getElement( i, j ) );
			}
		}
		return B;
	}
	
	/**
	 * 
	 * @return A transposed Matrix
	 */
	public Matrix transpose( )
	{
		Matrix B = new Matrix( getNCols(), getNRows() );
		for ( int i = 0; i < getNRows(); i++ )
		{
			for ( int j = 0; j < getNCols(); j++ )
			{
				B.setElement( j, i, getElement( i, j ) );
			}
		}
		return B;
	}
	
	/**
	 * 
	 */
	public void Print_Matrix()
	{
		//this.Print_Matrix( this );
		try{
			for ( int i = 0; i < getNRows(); i++ )
			{
				for ( int j = 0; j < getNCols(); j++ )
				{
					System.out.print( getElement( i, j ) );
					System.out.print(" ");
				}
				System.out.print( "\n" );
			}
		}
		catch ( NullPointerException NPE )
		{
			System.out.println( "Null" );
		}
		
	}
	
	/**
	 * 
	 * @param A
	 */
	public static void Print_Matrix( Matrix A)
	{
		
		if ( A != null )
		{
			System.out.println( A.MatrixName );
			for ( int i = 0; i < A.getNRows(); i++ )
			{
				
				for ( int j = 0; j < A.getNCols(); j++ )
				{
					System.out.print( A.getElement( i, j ) );
					System.out.print(" ");
				}
				System.out.print( "\n" );
			}
		}
		else
		{
			System.out.println( "Null" );
		}
//		double a = A.elem.length;	
//		double b = A.elem[0].length;
//		System.out.println( a + " " + b );
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */
	private static String Print_Matrix2str( Matrix A )
	{
		
		if ( A != null )
		{
			String Matrix_str = new String();
			Matrix_str += " [" + A.MatrixName + "] ";
			
			for ( int j = 0; j < A.getNCols(); j++ )
			{
				Matrix_str += "[" + j + "] ";
			}
			Matrix_str += "\n";
			for ( int i = 0; i < A.getNRows(); i++ )
			{
				Matrix_str += " [" + i + "] ";
				for ( int j = 0; j < A.getNCols(); j++ )
				{
					Matrix_str += A.getElement( i, j );
					Matrix_str += " ";
				}
				Matrix_str += "\n";
			}
			return Matrix_str;
		}
		else
		{
			return "Null";
		}
//		double a = A.elem.length;	
//		double b = A.elem[0].length;
//		System.out.println( a + " " + b );
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isIdentity()
	{
		if ( isSquare() == true )
		{
			if ( diagonalIsOne( 0 ) == true )
			{
				if ( leftoverIsZero() == true )
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 * 
	 * @return True If the number of columns is the same as the number of rows.
	 */
	public boolean isSquare()
	{
		if ( getNRows() != getNCols() )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */
	public static boolean isSquare( Matrix A )
	{
		if ( A.getNRows() != A.getNCols() )
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public double getElement( int i, int j )
	{
		return elem[i][j];
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @param A
	 * @return
	 */
	public static double getElement( int i, int j, Matrix A )
	{
		return A.elem[i][j];
	}
	
	/**
	 * @param A
	 * @return the matrixName
	 */
	public static char getMatrixName( Matrix A ) {
		return A.MatrixName;
	}
	
	/**
	 * @return the matrixName
	 */
	public char getMatrixName() {
		return MatrixName;
	}

	/**
	 * @param matrixName the matrixName to set
	 */
	private void setMatrixName(char matrixName) {
		MatrixName = matrixName;
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @param val
	 */
	public void setElement( int i, int j, double val )
	{
		elem[i][j] = val;
		return;
	}
	
	/**
	 * 
	 * @param val
	 */
	public void setElement( double[][] val )
	{
		
		int r = val.length;	 	//get the number of rows
		int c = val[0].length;	//get the number of columns
		if ( r == getNRows() && c == getNCols() )
		{
			for ( int i = 0; i < r; i++ )
			{
				for ( int j = 0; j < c; j++ )
				{
					//Copy the values from the array to the Matrix
					elem[i][j] = val[i][j];
					
				}
			}	
		}
		else
		{
			System.out.println( "Error! The Shapes are different!" );
		}
		return;
	}
	
	/**
	 * 
	 * @param val
	 * @param A
	 */
	public static void setElement( double[][] val, Matrix A )
	{
		int r = val.length;	 	//get the number of rows
		int c = val[0].length;	//get the number of columns
		if ( r == getNRows( A ) && c == getNCols( A ) )
		{
			for ( int i = 0; i < r; i++ )
			{
				for ( int j = 0; j < c; j++ )
				{
					//Copy the values from the array to the Matrix
					A.elem[i][j] = val[i][j];
					
				}
			}	
		}
		else
		{
			System.out.println( "Error! The Shapes are different!" );
		}
		return;
	}
	 
	/**
	 * 
	 * @param i
	 * @param j
	 * @param val
	 * @param A
	 */
	public static void setElement( int i, int j, double val, Matrix A )
	{
		A.elem[i][j] = val;
		return;
	}
	
	/**
	 * 
	 * @return
	 */
	private int getNCols() 
	{
		return num_cols;
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */
	private static int getNCols( Matrix A ) 
	{
		return A.num_cols;
	}
	
	/**
	 * 
	 * @return
	 */
	private int getNRows() 
	{
		return num_rows;
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */
	private static int getNRows( Matrix A ) 
	{
		return A.num_rows;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean leftoverIsZero() 
	{
		
		for ( int i = 0; i < getNRows(); i++ )
		{
			for ( int j = 0; j < getNCols(); j++ )
			{
				if ( i == j )
				{
					continue;
				}
				else 
				{
					if ( getElement( i, j ) != 0 )
					{
						return false;
					}
				}
			}
		}
		
		return true;
		
	}

	/**
	 * 
	 * @param counter
	 * @return
	 */
	private boolean diagonalIsOne( int counter ) 
	{
		
		if ( counter == getNCols() )
		{
			return true;
		}
		else if ( getElement( counter, counter ) != 1 )
		{
			return false;
		}
		else
		{
			return diagonalIsOne( counter + 1 ); 
		}
	}
	
	/**
	 * 
	 * @param B
	 * @return
	 */
	private boolean canAdd( Matrix B ) 
	{
		if ( getNRows() == B.getNRows() && getNCols() == B.getNCols() )
		{	
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private static boolean canAdd(Matrix A, Matrix B ) 
	{
		if ( A.getNRows() == B.getNRows() && A.getNCols() == B.getNCols() )
		{	
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param B
	 * @return
	 */
	private boolean canSub( Matrix B ) 
	{
		if ( getNRows() == B.getNRows() && getNCols() == B.getNCols() )
		{	
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return True if subtraction is possible; False otherwise
	 */
	private static boolean canSub(Matrix A, Matrix B ) 
	{
		if ( A.getNRows() == B.getNRows() && A.getNCols() == B.getNCols() )
		{	
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param B
	 * @return
	 */
	private boolean canMultipy( Matrix B ) 
	{
		if ( this.getNCols() == B.getNRows() )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private static boolean canMultiply( Matrix A, Matrix B ) 

	{
		if ( A.getNCols() == B.getNRows() )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString() {
		String pst = Matrix.Print_Matrix2str(this);
		//return String.format("Matrix [] %s", pst );
		return String.format( "%s", pst );
	}

	



	
}
