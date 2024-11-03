import java.util.*;

public class DetectingCycleInDirectedGraph {

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // we shall use the fact that topological sort can only work for DAG's
        // using the Kahn's algo for top sort in a DAG

        //getting all the degrees
        int[] degree = new int[V];
        for(int i = 0; i < V; i++) {
            for(Integer it: adj.get(i)) {
                degree[it]++;
            }
        }
        //creating the queue and adding all the elements with degree 1 to the queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }
        //now, performing the breadth first search on the q so obtained
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int Node = q.peek();
            q.remove();
            ans.add(Node);

            for(Integer it: adj.get(Node)) {
                degree[it]--;
                if(degree[it] == 0) {
                    q.add(it);
                }
            }
        }

        //doing the final comparison
        if(ans.size() == V) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
