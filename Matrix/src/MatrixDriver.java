
/**
 * @Name	MatrixDriver.java
 * @author 	Chris Fedun 10/05/2017
 * 
 */


public class MatrixDriver {

	private static void Multiply_Matrices( Matrix A, Matrix B )
	{
		
		Matrix C = Matrix.multiply( A, B );
		//C.toString();
		C.Print_Matrix();
		Matrix D = A.multiply( B );
		//D.toString();
		Matrix.Print_Matrix( D );
		return;
	}

	private static void Add_Matrices( Matrix A, Matrix B )
	{
		Matrix C = A.add( B );
		C.Print_Matrix();
		Matrix D = Matrix.add( A, B );
		Matrix.Print_Matrix( D );
		return;
	}
	
	private static void Sub_Matrices( Matrix A, Matrix B ) 
	{
		Matrix C = A.subtract( B );
		C.Print_Matrix();
		Matrix D = Matrix.subtract( A, B );
		Matrix.Print_Matrix( D );
		return;
	}

	private static void Transpose_Matrix( Matrix A, Matrix B ) 
	{
		Matrix C = A.transpose();
		Matrix.Print_Matrix( C );
		Matrix D = Matrix.transpose( B );
		D.Print_Matrix();
	}
	
	@SuppressWarnings("unused")
	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		double[][] a33 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] b43 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		double[][] c43 = { { 13, 29, 3 }, { 4, 58, 96 }, { 7, 98, 49 }, { 1, 19, 2 } };
		double[][] d33 = { { 4, 1, 7 }, { 9, 8, 2 }, { 3, 6, 5 } };
		double[][] e34 = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 } };
		Matrix A = new Matrix( 3, 3 ); //Initialize Matrix A
		Matrix B = new Matrix( 3, 3 ); //Initialize Matrix B
		A.setElement( a33 );
		B.setElement( d33 );
		Matrix.Print_Matrix(A);
		Matrix.Print_Matrix(B);
		System.out.print( A.toString() );
	

		Multiply_Matrices( A, B );
		Add_Matrices( A, B );
		Sub_Matrices( A, B );
		Transpose_Matrix( A, B );
		
		return;
	}



}