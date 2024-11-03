import java.lang.reflect.Array;
import java.util.*;

public class UndirectedCycleDetectionUsingDFS {

    public static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        //firstly, making the visited array as true for the currect element
        visited[node] = true;
        ///running the for loop for all the connected components
        for(Integer it: adj.get(node)) {
            if(!visited[it]) {
                if(dfs(it, node, visited, adj)) {
                    return true;
                }
            }else if(parent != it) {
                return true;
            }
        }
        return true;
    }

    public static boolean isCyCle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        int parent = -1;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {}
}
