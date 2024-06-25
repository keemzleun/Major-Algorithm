package A2dfs;

import java.util.ArrayList;
import java.util.List;

public class D2Basic2 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 5}, {2, 4}};

        adjList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : arr){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        visited = new boolean[6];
        dfs(0);
    }

    static void dfs(int start) {
        System.out.println(start);
        visited[start] = true;
        for(int target : adjList.get(start)) {  // target = 1, ...
            if (visited[target] == false) {
                dfs(target);
            }
        }
    }
}
