package asgn01;

import java.util.*;

/**
 * Adjacency List Representation of a Directed Graph
 * @author valentinaperic
 *
 */

public abstract class LDG extends DG
{
	LinkedList<Edge> [] adjList = null;
	
	public void maker()
	{
		adjList = new LinkedList[numVertices];
		arrayMaker();
	}
	
	public boolean existsEdge(int i, int j)
	{
		
		 Iterator<Edge> Iter = adjList[i].iterator();
		 while(Iter.hasNext())
		 {
			 if (Iter.next().equals(new Edge (i,j)))
			{
				 return true;
			}	 
		 }	 
		return false;
	}
	
	public void putEdge(int i, int j, int w)
	{
		if (!(existsEdge(i, j)))
		{
			adjList[i].add( new Edge( i, j ));
			inDegree[j]++;
			outDegree[i]++;
			numEdges++;
		}
	}
	
	public void removeEdge(int i, int j)
	{
		Iterator<Edge> Iter = adjList[i].iterator();
		while(Iter.hasNext())
		if (existsEdge(i, j))
		{
			while(Iter.hasNext())
			{
				adjList[i].remove(new Edge(i, j));  
				inDegree[j]--;
				outDegree[i]--;
				numEdges--;
			}
		}
	}
	
	public LinkedList<Edge>[] arrayMaker()
	{
		adjList = new LinkedList[numVertices];
		int i;
		for (i = 0; i < numVertices; i++ )
		{
			adjList[i] = new LinkedList<Edge>();
		}
		return adjList;
	}
		
	public ArrayList<Integer> adjacentVertices(int i)
	{
		ArrayList<Integer> adjVList = new ArrayList<Integer>();
		
		for (int j = 0; j < adjList[i].size(); j++)
		{	
			adjVList.add(adjList[i].get(j).getV2());				
		}
		return adjVList;
	}
}
	
	
	
	
	


