package asgn01;
import java.io.*;
import java.util.*;

/**
 * @author Valentina Peric
 * @course CSC406, Assignment #2
 * @dueDate March 3rd, 2016
 */

abstract class G 
{
	int numVertices;
	int numEdges;

	
	/** 
	 * Get the number of vertices in the graph
	 * @return number of vertices in the graph
	 */
	int numVertices()
	{
		return numVertices;
	}
	
	/** 
	 * Get the number of edges in the graph
	 * @return number of edges in the graph
	 */
	int numEdges()
	{
		return numEdges;
	}	

	/**
	 * Sees if an edge exists in the graph
	 * @return true if an edge exists else returns false
	 */

	boolean existsEdge (Edge e)
	{
		return existsEdge(e.getV1(), e.getV2());
	}

	abstract boolean existsEdge(int i, int j);
	
	/**
	 * adds the edge e to the graph if it doesn't already exist. 
	 * @param e: the edge e that is trying to be added to the graph
	 */

	void putEdge (Edge e)
	{
		putEdge(e.getV1(), e.getV2(), e.getw());
	}
	
	abstract void putEdge(int i, int j, int w);
	
	/**
	 * removes the edge e to the graph if it exists
	 * @param e: the edge e that is trying to be added to the graph
	 */
	

	void removeEdge (Edge e)
	{
		removeEdge(e.getV1(), e.getV2());
	}
	
	abstract void removeEdge(int i, int j);
	
	
	abstract ArrayList<Integer> adjacentVertices(int i);
	
	
	boolean areAdjacent(int i, int j)
	{
		return existsEdge(i, j);
	}
	
	abstract void maker();
	abstract void degree();
	
	boolean rangeCheck(int i)
	{
		if (i >= numVertices || i < 0 )
		{
			return false;
		}
		else
		{
			return true;
		}
	
	}
	
	void makeGraph(String TextFile)
	{
		try
		{
			
			Scanner scanner = new Scanner(new File(TextFile));
			String IntLine [] = new String [3];
			
			while(scanner.hasNext())
			{
				String i = scanner.nextLine();
				IntLine = i.split(" ");
				
				if (IntLine.length == 1)
				{
					numVertices = Integer.parseInt(IntLine[0]);	
					maker();
					degree();
				}
				else if (IntLine.length == 2)
				{
						putEdge(Integer.parseInt(IntLine[0]), Integer.parseInt(IntLine[1]), 1);		    
				}
				else
				{
						putEdge(Integer.parseInt(IntLine[0]), Integer.parseInt(IntLine[1]), Integer.parseInt(IntLine[2]));		    	
				}		
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found exception.");
		}
	}
}



		




