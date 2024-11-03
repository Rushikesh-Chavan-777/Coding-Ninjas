import java.lang.reflect.Array;
import java.util.*;

public class PrerequisiteTasks {

    public boolean isPossible(int N,int P, int[][] prerequisites) {
        //using the Kahn's algorithm to get things done
        //firstly, converting the argument prerequisites into an adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>()); // Initialize empty lists for each node
        }
        for(int i = 0; i < P ;i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //now that we are done converting to a graph. lets get into the Kahn's algorithm
        //creating the degree array
        int[] degree = new int[N];
        for(int i = 0; i < N; i++) {
            for(Integer it: adj.get(i)) {
                degree[it]++;
            }
        }
        //now that we are dome, lets fill the  queue with teh elements with NaN degrees
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }
        //now, we are done handling the q, lets get int the breadth with a while loop
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int Node = q.remove();
            ans.add(Node);

            for(Integer it: adj.get(Node)) {
                degree[it]--;
                if(degree[it] == 0) {
                    q.add(it);
                }
            }
        }
        //now taht we had gone in breath, lets check the final conditions. f topologcal srt is satisfied or not
        if(ans.size() == N) return true;
        return false;
    }


    public static void main(String[] args) {}
}
