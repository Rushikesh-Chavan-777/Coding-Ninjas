import java.util.*;

public class TopologicalSort {
    public static void dfs(int i, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        //firstly making the visited as positive
        visited[i] = true;
        //traversing in depth
        for(Integer it: adj.get(i)) {
            if(!visited[it]) dfs(it, st, adj, visited);
        }
        //adding the element from the end into the stack
        st.push(i);
    }


    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // we shall use the standard dfs approach here
        // lets dec;are the stack, etc
        int V = adj.size();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) dfs(i, st, adj, visited);
        }
        //now, lets create an answer array
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()) {
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
