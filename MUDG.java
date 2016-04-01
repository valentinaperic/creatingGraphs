package asgn01;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Matrix representation of an unDirected Graph
 * @author valentinaperic
 */

public abstract class MUDG extends UDG
{
	
    int [][] matrix = null;
	
	void maker()
	{
		matrix = new int [numVertices][numVertices];	
	}

	public boolean existsEdge(int i, int j)
	{
		return matrix[i][j] > 0;

	}

	public void putEdge(int i, int j, int w)
	{
		if (!existsEdge(i, j))
		{
			matrix[i][j] = w;
			matrix[j][i] = w;
			Degrees[i]++;
		}
	}

	public void removeEdge(int i, int j)
	{
		if (existsEdge(i, j))
		{
			matrix[i][j] = 0;
			matrix[j][i] = 0;
			Degrees[i]--;		
		}

	}

	public ArrayList<Integer> adjacentVertices(int i)
	{
		ArrayList<Integer> adjList = new ArrayList<Integer>();

		for (int j = 0; j < numVertices; j++)
		{
			if ( matrix[i][j] > 0)
			{
				adjList.add(j);
			}		
		}
		return adjList;
	}

	public String toString()
	{
		String str = "";
		for (int row = 0; row < matrix.length; row++) 
		{
			for (int column = 0; column < matrix[row].length; column++) 
			{
				str += matrix[row][column] + "";
			}
			str +="\n";
		}
		return str;
	}
}
