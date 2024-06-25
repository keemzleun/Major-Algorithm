package A3bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B3Basic3 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        // 배열에서 각 노드가 start node에서 얼마나 떨어져 있는지 숫자값을 담은 새로운 배열 출력
        int[][] arr = {{0,1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        adjList = new ArrayList<>();
        visited = new boolean[5];
        distance = new int[5];
        for (int i = 0; i < 5; i++) {   // 5 = 노드의 개수
            adjList.add(new ArrayList<>());
        }
        for(int[] a : arr){
            adjList.get(a[0]).add(a[1]);
            // adjList.get(a[1]).add(a[0]);  // 양방향일 경우
        }
        int start = 0;
        int end = 3;
        int minDis = bfs(start, end);
        System.out.println(minDis);

    }
    static int bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[0] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            visited[temp] = true;
            for (int target : adjList.get(temp)) {
                // target을 queue에 add하기 전에 true로 세팅
                if (!visited[target]){
                    q.add(target);
                    distance[target] = distance[temp] + 1;
                    visited[target] = true;
                    if(target == end){
                        return distance[target];
                    }
                }
            }
        }
        return -1;
    }
}
