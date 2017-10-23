package com.yougal.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
	
	
	
	 // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();
    }
    
    static class Graph
    {
        private int V;   // No. of vertices
        private List<LinkedList<Integer>> adj; // Adjacency List
     
        //Constructor
        Graph(int v)
        {
            this.V = v;
            adj = new ArrayList<LinkedList<Integer>>(v);
            for (int i=0; i<this.V; ++i)
                adj.add(i,new LinkedList<>());
        }
     

		// Function to add an edge into the graph
        void addEdge(int v,int w) { 
        	adj.get(v).add(w); 
        }
        
        public void topologicalSort() {
        	Set<Integer> visited = new HashSet<>();
        	Stack<Integer> stk = new Stack<>();
        	while(visited.size()<this.V){
        		int vertex = getVertex(visited);
        		topologicalSortUtils(vertex, visited, stk);
        	}
        	System.out.println(stk.toString());
        }
        
        private int getVertex(Set<Integer> visited) {
        	for (int i = V-1; i >=0; i--) {
				if(!visited.contains(i)){
					return i;
				}
			}
			return -1;
		}


		private void topologicalSortUtils(int i, Set<Integer> visited, Stack<Integer> stk){
        	if(!visited.contains(i)){
        		visited.add(i);
        		LinkedList<Integer> connectedVertex = adj.get(i);
        		if(connectedVertex==null || connectedVertex.isEmpty()){
        			stk.push(i);
        		}else{
        			for (Integer vertex : connectedVertex) {
						topologicalSortUtils(vertex, visited,stk);
					}
        			stk.push(i);
        		}
        	}
        }
    }
	

}
