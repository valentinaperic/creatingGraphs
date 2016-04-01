package asgn01;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Tester 
{
	public static void main ( String[] args )
			throws IOException
	{
		//This is where TextFile is
		String currentDir = new File(" ").getAbsolutePath();
		currentDir = currentDir.substring(0, currentDir.length()-1);

		System.out.println("Input the Weighted file");

		Scanner scan = new Scanner(System.in);
		String file = scan.nextLine();

		String Filename = currentDir+"src/asgn01/" + file;
		
        //Weighted Graphs
		WMDG WeightedMatrixDirectedGraph = new WMDG(Filename);
		WLDG WeightedListDirectedGraph = new WLDG(Filename);  
		WMUDG WeightedMatrixUnDirectedGraph = new WMUDG(Filename);
		WLUDG WeightedListUnDirectedGraph = new WLUDG(Filename); 

		System.out.println("Input the Unweighted file");
		file = scan.nextLine();
		Filename = currentDir+"src/asgn01/" + file;

		//Unweighted Graphs
		UWMDG UnweightedMatrixDirectedGraph = new UWMDG(Filename);
		UWLDG UnweightedListDirectedGraph = new UWLDG(Filename);
		UWMUDG UnweightedMatrixUndirectedGraph = new UWMUDG(Filename);
		UWLUDG UnWeightedListUnDirectedGraph = new UWLUDG(Filename);
	

		File outputFile = new File (currentDir+"src/asgn01/outputFile");

		if (!outputFile.exists())
		{
			outputFile.createNewFile();
		}

		FileWriter fWriter = new FileWriter(outputFile);
		BufferedWriter bWriter = new BufferedWriter(fWriter);


		/**
		 * Unweighted Matrix Directed Graph Representations
		 */

		//Label for Unweighted Matrix Directed Graph Representations
		bWriter.write("Unweighted Matrix Directed Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Matrix Representation for Unweighted Matrix Directed Graphs
		bWriter.write("UWMDG: Matrix Representation");
		bWriter.write("\r\n");
		bWriter.write(UnweightedMatrixDirectedGraph.toString());
		bWriter.write("\r\n");

		//Removing an Edge for Unweighted Matrix Directed Graphs. Edge(0,2)
		bWriter.write("UWMDG: Matrix Representation after Edge(0,2) is Removed");
		bWriter.write("\r\n");
		UnweightedMatrixDirectedGraph.removeEdge(0, 2);
		bWriter.write(UnweightedMatrixDirectedGraph.toString());
		bWriter.write("\r\n");

		//Adjacent Vertices for Unweighted Matrix Directed Graphs. Vertice(0)
		//NOTE: Will only print out 3 because the edge 0,2 was removed!
		bWriter.write("UWMDG: Array list of adjacent vertices to Node 0 after Edge(0,2) is removed");
		bWriter.write("\r\n");
		bWriter.write("" + UnweightedMatrixDirectedGraph.adjacentVertices(0));
		bWriter.write("\r\n");
		bWriter.write("\r\n");


		/**
		 * Weighted Matrix Directed Graph Representations
		 */

		//Label for Weighted Matrix Directed Graph Representations
		bWriter.write("Weighted Matrix Directed Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Matrix Representation for Weighted Matrix Directed Graphs
		bWriter.write("WMDG: Matrix Representation");
		bWriter.write("\r\n");
		bWriter.write(WeightedMatrixDirectedGraph.toString());
		bWriter.write("\r\n");

		//Removing an Edge for Weighted Matrix Directed Graphs. Edge(2,3)
		bWriter.write("WMDG: Matrix Representation after Edge(2,3) is Removed");
		bWriter.write("\r\n");
		WeightedMatrixDirectedGraph.removeEdge(2, 3);
		bWriter.write(WeightedMatrixDirectedGraph.toString());
		bWriter.write("\r\n");

		//Putting an Edge for Weighted Matrix Directed Graphs. Edge(2,3)
		//NOTE: Edge is put back for adjacent vertices which will be tested next
		bWriter.write("WMDG: Matrix Representation after Edge(2,3) is Added");
		bWriter.write("\r\n");
		WeightedMatrixDirectedGraph.putEdge(2, 3, 3);
		bWriter.write(WeightedMatrixDirectedGraph.toString());
		bWriter.write("\r\n");

		//Adjacent Vertices for Weighted Matrix Directed Graphs. Vertice(0)
		bWriter.write("WMDG: Array list of adjacent vertices to Node 0");
		bWriter.write("\r\n");
		bWriter.write("" + WeightedMatrixDirectedGraph.adjacentVertices(0));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		/**
		 * Unweighted List Directed Graph Representations
		 */

		//Label for UnWeighted List Directed Graph Representations
		bWriter.write("Unweighted List Directed Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Removing an Edge for Unweighted List Directed Graphs. Edge(2,3)
		bWriter.write("UWLDG: Removing Edge (2,3) and checking for its existence");
		UnweightedListDirectedGraph.removeEdge(2, 3);
		bWriter.write("\r\n");
		bWriter.write("" + UnweightedListDirectedGraph.existsEdge(2, 3));
		bWriter.write("\r\n");
		bWriter.write("\r\n");
		
		//Putting an Edge for Unweighted List Directed Graphs. Edge(2,3)
		bWriter.write("UWLDG: Adding Edge(2,3) and checking for its existence");
		bWriter.write("\r\n");
		UnweightedListDirectedGraph.putEdge(2, 3, 1);
		bWriter.write("" + UnweightedListDirectedGraph.existsEdge(2, 3));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Adjacent Vertices for Unweighted List Directed Graphs. Vertice(0)
		bWriter.write("UWLDG: Array list of adjacent vertices to Node 0");
		bWriter.write("\r\n");
		bWriter.write("" + UnweightedListDirectedGraph.adjacentVertices(0));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		/**
		 * Weighted List Directed Graph Representations
		 */

		//Label for Weighted List Directed Graph Representations
		bWriter.write("Weighted List Directed Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Removing an Edge for Weighted List Directed Graphs. Edge(3,1)
		bWriter.write("WLDG: Removing Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		WeightedListDirectedGraph.removeEdge(3, 1);
		bWriter.write("" + WeightedListDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");


		//Putting an Edge for Weighted List Directed Graphs. Edge(3,1)
		bWriter.write("WLDG: Adding Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		WeightedListDirectedGraph.putEdge(3, 1, 4);
		bWriter.write("" + WeightedListDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");
		
		//Adjacent Vertices for Weighted List Directed Graphs. Vertice(3)
		bWriter.write("WLDG: Array list of adjacent vertices to Node 3");
		bWriter.write("\r\n");
		bWriter.write("" + WeightedListDirectedGraph.adjacentVertices(3));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		/**
		 * Matrix UnWeighted UnDirected Graph Representations
		 */

		//Label for Matrix UnWeighted UnDirected Graph Representations
		bWriter.write("Matrix UnWeighted UnDirected Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Matrix Representation for UnWeighted UDirected Graphs
		bWriter.write("UWMUDG: Matrix Representation");
		bWriter.write("\r\n");
		bWriter.write(UnweightedMatrixUndirectedGraph.toString());
		bWriter.write("\r\n");

		//Removing an Edge for UnWeighted UnDirected Graph. Edge(3,1)
		bWriter.write("UWMUDG: Removing Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		UnweightedMatrixUndirectedGraph.removeEdge(3, 1);
		bWriter.write("" + UnweightedMatrixUndirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Putting an Edge for UnWeighted UnDirected Graph. Edge(3,1)
		bWriter.write("Adding Edge(3,1) and testing for its existence");
		bWriter.write("\r\n");
		UnweightedMatrixUndirectedGraph.putEdge(3, 1, 1);
		bWriter.write("" + UnweightedMatrixUndirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Adjacent Vertices for Weighted List Directed Graphs. Vertice(3)
		bWriter.write("UWMUDG: Array list of adjacent vertices to Node 3");
		bWriter.write("\r\n");
		bWriter.write("" + UnweightedMatrixUndirectedGraph.adjacentVertices(3));
		bWriter.write("\r\n");
		bWriter.write("\r\n");
		
		/**
		 * Matrix Weighted UnDirected Graph Representations
		 */

		//Label for Matrix Weighted UnDirected Graph Representations
		bWriter.write("Matrix Weighted UnDirected Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Matrix Representation for Weighted UDirected Graphs
		bWriter.write("WMUDG: Matrix Representation");
		bWriter.write("\r\n");
		bWriter.write(WeightedMatrixUnDirectedGraph.toString());
		bWriter.write("\r\n");

		//Removing an Edge for Weighted UnDirected Graph. Edge(3,1)
		bWriter.write("WMUDG: Removing Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		WeightedMatrixUnDirectedGraph.removeEdge(3, 1);
		bWriter.write("" + WeightedMatrixUnDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Putting an Edge for Weighted UnDirected Graph. Edge(3,1)
		bWriter.write("WMUDG: Adding Edge(3,1) and testing for its existence");
		bWriter.write("\r\n");
		WeightedMatrixUnDirectedGraph.putEdge(3, 1, 1);
		bWriter.write("" + WeightedMatrixUnDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Adjacent Vertices for Weighted List Directed Graphs. Vertice(3)
		bWriter.write("WMUDG: Array list of adjacent vertices to Node 3");
		bWriter.write("\r\n");
		bWriter.write("" + WeightedMatrixUnDirectedGraph.adjacentVertices(3));
		bWriter.write("\r\n");
		bWriter.write("\r\n");
		

		/**
		 * Weighted List UnDirected Graph Representations
		 */

		//Label for Weighted List UnDirected Graph Representations
		bWriter.write("Weighted List UnDirected Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Removing an Edge for Weighted List UnDirected Graphs. Edge(3,1)
		bWriter.write("WLUDG: Removing Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		WeightedListUnDirectedGraph.removeEdge(3, 1);
		bWriter.write("" + WeightedListUnDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");


		//Putting an Edge for Weighted List UnDirected Graphs. Edge(3,1)
		bWriter.write("WLUDG: Adding Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		WeightedListUnDirectedGraph.putEdge(3, 1, 4);
		bWriter.write("" + WeightedListUnDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");
		
		//Adjacent Vertices for Weighted List UnDirected Graphs. Vertice(3)
		bWriter.write("WLUDG: Array list of adjacent vertices to Node 3");
		bWriter.write("\r\n");
		bWriter.write("" + WeightedListUnDirectedGraph.adjacentVertices(3));
		bWriter.write("\r\n");
		bWriter.write("\r\n");
		
		/**
		 * UnWeighted List UnDirected Graph Representations
		 */

		//Label for UnWeighted List UnDirected Graph Representations
		bWriter.write("UnWeighted List UnDirected Graph Representations");
		bWriter.write("\r\n");
		bWriter.write("\r\n");

		//Removing an Edge for UnWeighted List UnDirected Graphs. Edge(3,1)
		bWriter.write("UWLUDG: Removing Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		UnWeightedListUnDirectedGraph.removeEdge(3, 1);
		bWriter.write("" + UnWeightedListUnDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");


		//Putting an Edge for UnWeighted List UnDirected Graphs. Edge(3,1)
		bWriter.write("UWLUDG: Adding Edge (3,1) and checking for its existence");
		bWriter.write("\r\n");
		UnWeightedListUnDirectedGraph.putEdge(3, 1, 4);
		bWriter.write("" + UnWeightedListUnDirectedGraph.existsEdge(3, 1));
		bWriter.write("\r\n");
		bWriter.write("\r\n");
		
		//Adjacent Vertices for UnWeighted List UnDirected Graphs. Vertice(3)
		bWriter.write("UWLUDG: Array list of adjacent vertices to Node 3");
		bWriter.write("\r\n");
		bWriter.write("" + UnWeightedListUnDirectedGraph.adjacentVertices(3));
		bWriter.write("\r\n");
		bWriter.write("\r\n");


		bWriter.close();
	}
}

