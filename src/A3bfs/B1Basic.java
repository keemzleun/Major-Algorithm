package A3bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B1Basic {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] arr = {{0,1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        adjList = new ArrayList<>();
        visited = new boolean[5];
        for (int i = 0; i < 5; i++) {   // 5 = 노드의 개수
            adjList.add(new ArrayList<>());
        }
        for(int[] a : arr){
            adjList.get(a[0]).add(a[1]);
            // adjList.get(a[1]).add(a[0]);  // 양방향일 경우
        }
        // bfs 각 노드를 방문하고 출력
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int temp = q.poll();
            // visited[temp] = true;
            System.out.println(temp);
            for (int target : adjList.get(temp)) {
                // target을 queue에 add하기 전에 true로 세팅
                if (!visited[target]){
                    q.add(target);
                    visited[target] = true;
                }
            }
        }
    }
}
