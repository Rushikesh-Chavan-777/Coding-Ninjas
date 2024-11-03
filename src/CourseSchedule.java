import java.util.*;

public class CourseSchedule {



    public static int[] findOrder(int N,int P, ArrayList<ArrayList<Integer>> prerequisites) {
        //using the Kahn's algorithm to get things done
        //firstly, converting the argument prerequisites into an adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>()); // Initialize empty lists for each node
        }
        for(int i = 0; i < P ;i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
        //now that we are done converting to a graph, lets get into the Kahn's algorithm
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
        int[] ans = new int[N];
        int i = 0;
        while(!q.isEmpty()) {
            int Node = q.remove();
            ans[i++] = Node;

            for(Integer it: adj.get(Node)) {
                degree[it]--;
                if(degree[it] == 0) {
                    q.add(it);
                }
            }
        }
        //now that we had gone in breath, lets check the final conditions i.e if topological srt is satisfied or not
        if(i == N) return ans;
        int[] ans1 = {};
        return ans1;
    }



    public static void main(String[] args) {}
}
