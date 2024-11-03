import java.util.*;

public class NumberOfProvinces {


    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {

        //making the visited true
        visited[node] = true;

        //traversing the loop
        for(Integer i : adjList.get(node)) {
            if(!visited[i]) {
                dfs(i, adjList, visited);
            }
        }

    }


    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        // we shall first convert our adjacency matrix to an adjacency list, then solve it using DFS
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        //creating empty lists inside the list above
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        //running 2 loops of the matrix to get our graph into a list
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(adj.get(i).get(j) == 1 && i != j ) {
                    adjList.get(i).add(j);
                }
            }
        }
        //now, getting ot the dfs part. Creating the variables
        boolean[] visited = new boolean[V];
        int counter = 0;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                counter++;
                dfs(i, adjList, visited);
            }
        }
        return counter;
    }


    public static void main(String[] args) {

    }
}
