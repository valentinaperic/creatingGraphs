package asgn01;

import java.util.*;

/**
 * Adjacency List Representation of an UnDirected Graph
 * @author valentinaperic
 *
 */

public abstract class LUDG extends UDG
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
			adjList[j].add( new Edge( j, i ));
			Degrees[i]++;
			Degrees[j]++;
			numEdges++;
			
			
		}
	}
	
	public void removeEdge(int i, int j)
	{
		Iterator<Edge> Iter = adjList[i].iterator();

		if ((existsEdge(i, j)))
		{

			while(Iter.hasNext())
			{
				Edge e = Iter.next();
				if (e.getV1() == i && e.getV2() == j)
				{
					adjList[i].remove(); 
					Degrees[i]--;		
					numEdges--;			
				}
			}
		}
		Iterator<Edge> Iter1 = adjList[j].iterator();

		if ((existsEdge(j, i)))
		{

			while(Iter1.hasNext())
			{
				Edge e = Iter1.next();
				if (e.getV1() == j && e.getV2() == i)
				{
					adjList[j].remove(); 
					
					Degrees[j]--;
				}
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
	