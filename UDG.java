package asgn01;

/**
 * UnDirected Graph Representation
 * @author valentinaperic
 */



public abstract class UDG extends G
{
	
	
	int [] Degrees = null;

	public void degree()
	{
		Degrees = new int [numVertices];		
	}
	
	public int Degrees(int i)
	{
		return Degrees [i];
	}	
}
