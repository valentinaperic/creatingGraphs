package asgn01;

/**
 * Directed Graph Representation
 * @author valentinaperic
 */

public abstract class DG extends G
{
	
	
	int [] inDegree = null;
	int [] outDegree = null;
	
	public void degree()
	{
		inDegree = new int [numVertices];
		outDegree = new int [numVertices];	
		
	}
	
	public int inDegree(int i)
	{
		return inDegree [i];
	}
	
	public int outDegree(int i)
	{
		return outDegree [i];
	}

	
}
