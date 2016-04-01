package asgn01;

class Edge {
	
	private int v1;
	private int v2;
	private int w;
    
	Edge(int i, int j)
	{
		v1 = i;
		v2 = j;
	}
	/**
	 * Gets the first vertex of the edge
	 * @return the first vertex
	 */
	int getV1(  )
	{
		return v1;
	}
	
	/**
	 * Gets the second vertex of the edge
	 * @return the second vertex
	 */
	int getV2(  )
	{
		return v2;
	}

	/**
	 * Gets the weight of the edge vertex
	 * @return the weight of the edge
	 */
	
	int getw(  )
	{
		return w;
	}
	
	
	public String toString()
	{
		return (this.v1 + " " + this.v2 + " " + this.w);
		
	}
	
	
	/**
	 * Compares two vertices
	 * @param other the vertex you are comparing
	 * @return the vertex 
	 */
	
	public boolean equals( Object otherEdge )
	{
		Edge e1 = (Edge) otherEdge;
		return (this.v1 == e1.getV1() && this.v2 == e1.getV2() );
		
	}


	
	

}
