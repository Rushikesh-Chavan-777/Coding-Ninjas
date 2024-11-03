import java.util.*;

public class KahnsAlgo {



    public static ArrayList<Integer> KahnsTopoSort(ArrayList<ArrayList<Integer>> adj, int V){
        //using the BFS approach here in this question
        //creating the degree array first
        int[]  degree = new int[V];
        for(int i = 0; i < V; i++) {
            for(Integer it: adj.get(i)) {
                degree[it]++;
            }
        }
        //now, creating a q and filling the elements with degree as 0 in the q
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }
        //now, performing the BFS
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int Node = q.poll();
            ans.add(Node);

            for(Integer it: adj.get(Node)) {
                degree[it]--;
                if(degree[it] == 0) q.add(it);
            }
        }
        //returning the sorted by topological order ArrayList
        return ans;
    }

    public static void main(String[] args) {

    }
}
