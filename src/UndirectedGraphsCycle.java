import java.util.*;



public class UndirectedGraphsCycle {

    static class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static boolean bfs(int i, int[] parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        //firstly creating the queue and making the present one as true
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, -1));
        visited[i] = true;

        while(!q.isEmpty()) {
            int u = q.peek().first;
            int v = q.peek().second;
            q.remove();
            for(Integer k : adj.get(u)) {
                if(!visited[k]) {
                    q.add(new Node(k, u));
                    visited[k] = true;
                }else if(v != k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // we shall use a bfs approach here and explore whenever we have  visited a node and it isnt ists parent leading to  the cycle detection
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        //creating the parent array
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        //running the required for loop
        for(int i = 0; i < V; i++) {
            if(!visited[i]){
                if(bfs(i, parent, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfs1(int start, int[] parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        //making the queue of nodes
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, -1));
        visited[start] = true;

        while(!q.isEmpty()) {
            int u = q.peek().first;
            int v = q.peek().second;
            q.remove();
            for(Integer it : adj.get(u)){
                if(!visited[u]) {
                    bfs1(it, parent, visited, adj);
                    visited[it] = true;
                }else if(v != it) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCycle1(ArrayList<ArrayList<Integer>> adj) {
        //using the BFS approach
        int V = adj.size();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        //running the for loop to run accross all components os the graph mechanism
        for (int i = 0; i < V ; i ++) {
            if(!visited[i]) {
                if(bfs1(i, parent, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {}
}



