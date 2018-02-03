package com.yougal.graph;

import java.util.Set;
import java.util.TreeSet;

public class MinimalSpanningTree {
	
	public static void main (String[] args)
    {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
		MinimalSpanningTree t = new MinimalSpanningTree();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
 
        // Print the solution
        t.primMST(graph);
    }

	private void primMST(int[][] graph) {
		int parent[]= new int[graph.length];
		
		Set<Integer> addedVertices = new TreeSet<>();
		
		addedVertices.add(0);
		parent[0]=-1;
		while(addedVertices.size()<graph.length) {
			
			int minDistance = Integer.MAX_VALUE,minVertices =Integer.MAX_VALUE,minParent = Integer.MAX_VALUE;
			for (Integer vertex : addedVertices) {
				for (int i=0;i<graph[vertex].length;i++) {
					if(!(i==vertex || addedVertices.contains(i))) {
						if(graph[vertex][i]!=0 && graph[vertex][i]<minDistance) {
							minDistance=graph[vertex][i];
							minVertices=i;
							minParent=vertex;
						}
					}
				}
			}
			parent[minVertices]=minParent;
			addedVertices.add(minVertices);
		}
		System.out.println("Edge		Weight");
		for (Integer vertex : addedVertices) {
			if(parent[vertex]!=-1) {
				System.out.println(parent[vertex] + " - " + vertex + " - " + graph[parent[vertex]][vertex]);
			}
		}
		
	}

}
