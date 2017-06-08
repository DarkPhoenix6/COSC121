/**
 * Polynomial
 * polyAdder
 * PolyAdder.java
 */
package polyAdder;

/**
 * @class	PolyAdder
 * @author 	Chris 
 * @date	May 31, 2017
 *
 */
public class PolyAdder {

	private PolyList PL1;
	private PolyList PL2;
	private PolyList result;
	
	/**
	 * @return the pL1
	 */
	public PolyList getPL1() {
		return PL1;
	}
	/**
	 * @return the pL2
	 */
	public PolyList getPL2() {
		return PL2;
	}
	/**
	 * @return the result
	 */
	public PolyList getResult() {
		return result;
	}
	public  void createList( String string, int select )
	{

		splitString(string, select);
	}
	/**
	 * @param string
	 * @param select
	 * @Description splits the string
	 */
	private void splitString(String string, int select) {
		String[] stringSplit = string.split("\\s");
		String[] polyArray = new String[stringSplit.length / 2];
		int j = 0;
		int i = 0;
				for ( String m: stringSplit )
				{
					if ( j % 2 == 0 )
					{
						polyArray[ j++ /2 ] = m + " "; 
					}
					else
					{
						polyArray[ j++ /2 ] += m; 
					}
					
					//System.out.println(m);
				}
				for ( String p: polyArray)
				{
					if ( i == 0 )
					{
						if ( select == 1 )
						{
							PL1 = new PolyList( p );
						}
						else
						{
							PL2 = new PolyList( p );
						}
						
						i++;
					}
					else
					{
						String[] PL = p.split("\\s");
						if ( select == 1 )
						{
							
							PL1.addNode(Integer.valueOf( PL[0] ), Integer.valueOf( PL[1] ));
						}
						else
						{
							PL2.addNode(Integer.valueOf( PL[0] ), Integer.valueOf( PL[1] ));
						}
					}
					System.out.println(p);
				}
	}
	
	public void add()
	{
		PolyNode saveSpotPL1 = PL1.getTemp();
		PolyNode saveSpotPL2 = PL2.getTemp();
		PL1.setTemp(PL1.getHead());
		PL2.setTemp(PL2.getHead());
		addList();
		PL1.setTemp(saveSpotPL1);
		PL2.setTemp(saveSpotPL2);
	}
	private void addList()
	{
		if ( PL1.getTemp() != null && PL2.getTemp() != null )
		{
			if ( PL1.getTemp().getExponent() == PL2.getTemp().getExponent() )
			{
				if ( result == null )
				{
					result = new PolyList( PL1.getTemp().getCoefficient() + PL2.getTemp().getCoefficient(), PL1.getTemp().getExponent() );
					PL1.iterateTemp();
					PL2.iterateTemp();
					addList();
				}
				else
				{
					
					result.addNode( PL1.getTemp().getCoefficient() + PL2.getTemp().getCoefficient(), PL1.getTemp().getExponent() );
					PL1.iterateTemp();
					PL2.iterateTemp();
					addList();
				}
			}
			else if ( PL1.getTemp().getExponent() > PL2.getTemp().getExponent() )
			{
				if ( result == null )
				{
					result = new PolyList( PL1.getTemp().getCoefficient(), PL1.getTemp().getExponent() );
					PL1.iterateTemp();
					addList();
				}
				else
				{
					result.addNode( PL1.getTemp().getCoefficient(), PL1.getTemp().getExponent() );
					PL1.iterateTemp();
					addList();
				}
			}
			else
			{
				if ( result == null )
				{
					result = new PolyList( PL2.getTemp().getCoefficient(), PL2.getTemp().getExponent() );
					PL2.iterateTemp();
					addList();
				}
				else
				{
					result.addNode( PL2.getTemp().getCoefficient(), PL2.getTemp().getExponent() );
					PL2.iterateTemp();
					addList();
				}
			}
		}
		else if( PL1.getHead() == null && PL2.getHead() == null )
		{
			EmptyListException e = new EmptyListException();
			throw e;
		}
		else
		{
			addRemaining();
		}
	}

	/**
	 * 
	 */
	private void addRemaining() {
		// TODO Auto-generated method stub
		if ( PL1.getTemp() != null )
		{
			result.addNode( PL1.getTemp().getCoefficient(), PL1.getTemp().getExponent() );
			PL1.iterateTemp();
			addRemaining();
		}
		else if ( PL2.getTemp() != null )
		{
			result.addNode( PL2.getTemp().getCoefficient(), PL2.getTemp().getExponent() );
			PL2.iterateTemp();
			addRemaining();
		}
		else
		{
			return;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("PolyAdder\n"
				+ "PL1= %s\n"
				+ "PL2= %s\n"
				+ "result=%s", PL1, PL2, result);
	}
	
	
}
