package A3bfs;

import java.util.*;

public class B4가장먼노드 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int answer = 0;

        adjList = new ArrayList<>();
        visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, 1);
        for (int i = 0; i < n+1; i++) {   // 5 = 노드의 개수
            adjList.add(new ArrayList<>());
        }
        for(int[] a : edge){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);  // 양방향일 경우
        }
        bfs(1, n);
        int max = Arrays.stream(distance).max().getAsInt();
        int count = (int)Arrays.stream(distance).filter(a->a==max).count();
        System.out.println(count);

    }
    static void bfs(int start, int end){
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
                }
            }
        }
    }
}
