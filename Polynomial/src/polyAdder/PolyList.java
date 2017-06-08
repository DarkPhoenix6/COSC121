/**
 * Polynomial
 * polyAdder
 * PolyList.java
 */
package polyAdder;

/**
 * @class	PolyList
 * @author 	Chris 
 * @date	May 31, 2017
 *
 */
public class PolyList {

	private final PolyNode PList;
	private PolyNode temp;
	

	public PolyList()
	{
		PList = new PolyNode();
		setTemp(PList);
	}
	
	public PolyList( PolyNode PL )
	{
		PList = new PolyNode( PL );
		setTemp(PList);
	}



	/**
	 * @param p
	 */
	public PolyList(String p) {
		// TODO Auto-generated constructor stub
		String[] PL = p.split("\\s");
		//System.out.print(PL[0] + " " + PL[1]);
		PList = new PolyNode( Integer.valueOf( PL[0] ), Integer.valueOf( PL[1] ) );
		setTemp(PList);
	}

	/**
	 * @param i
	 * @param exponent
	 */
	public PolyList(int coef, int exponent) {
		// TODO Auto-generated constructor stub
		PList = new PolyNode( coef, exponent );
		setTemp(PList);
	}

	/**
	 * @return the temp
	 */
	public PolyNode getTemp() {
		return temp;
	}

	
	
	public PolyNode getHead() {
		return PList;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(PolyNode temp) {
		this.temp = temp;
	}
	
	public void addNode( int coefficient, int exp )
	{
		if ( coefficient != 0 )
		{
			temp.setNext(new PolyNode( coefficient, exp ));
			iterateTemp();
		}
	}
	
	public void iterateTemp()
	{
	
			temp = temp.getNext();
	}

	/**
	 * @return
	 */
	private String printPolyList() {
		// TODO Auto-generated method stub
		PolyNode saveSpot = temp;
		setTemp( getHead() );
		//iterateTemp();
		String result = null;
		while ( temp != null )
		{
		
			if ( result == null )
			{
				if ( temp.getCoefficient() > 0  && temp == getHead() )
				{
					result = new String(temp.toString());
				}
				else if ( temp.getCoefficient() < 0 )
				{
					result = new String("- " + temp);
				}
				else
				{
					result = new String( "+ " +temp);
				}
				if ( temp.getNext() != null )
				{
					result += " ";
						iterateTemp();
				}
				else
				{
					iterateTemp();
				}
			}
			else
			{
				if ( temp.getCoefficient() > 0  && temp == getHead() )
				{
					result += temp;
				}
				else if ( temp.getCoefficient() < 0 )
				{
					result += "- " + temp;
				}
				else
				{
					result += "+ " +temp;
				}
				if ( temp.getNext() != null )
				{
					result += " ";
						iterateTemp();
				}
				else
				{
					iterateTemp();
				}
			}
		}
		
		setTemp( saveSpot );
		return result;
	}
	
	@Override
	public String toString()
	{
		
		String Poly = printPolyList();
		return String.format("\n%s", Poly );
	}

	
	
}
