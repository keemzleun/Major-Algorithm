package A2dfs;

import java.util.ArrayList;
import java.util.List;

public class D1Basic {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        // 방문할 수 있는 정점이 여러개인 경우
        // 정점 번호가 작은 것을 먼저 방문하는 dfs 알고리즘 형식의 방문 순서를 출력하기
        // 0, 1, 3, 2, 4
        int[][] arr = {{0,1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        // 관계성을 가지는 리스트를 만들기 !
        adjList = new ArrayList<>();

        // List 안에 List 넣어주기
        for (int i = 0; i < 5; i++) {   // 5 = 노드의 개수
            adjList.add(new ArrayList<>());
        }
        for(int[] a : arr){
            adjList.get(a[0]).add(a[1]);
            // adjList.get(a[1]).add(a[0]);  // 양방향일 경우
        }
        visited = new boolean[5];
        dfs(0);
    }
    static void dfs(int start){
        System.out.println(start);
        visited[start] = true;
        for(int target : adjList.get(start)) {  // target = 1, ... start 노드에 인접한 모든 노드의 리스트를 반환
            if (visited[target] == false) {
                dfs(target);
            }
        }
    }
}

