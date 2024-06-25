package A2dfs;

import java.util.ArrayList;
import java.util.List;

public class D5네트워크 {
    static public boolean[] visited;
    static public List<List<Integer>> list;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = 0;

        list = new ArrayList<>();
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(visited[i]== false){
                dfs(computers, i, visited);
                answer++;
            }
        }
        System.out.println(answer);
    }

    static public void dfs(int[][] computers, int now_com, boolean[] visited){
        visited[now_com] = true;
        // 연결되어있다면 타고 들어가기
        for(int j=0; j<computers.length; j++){
            if(computers[now_com][j] == 1 && visited[j] == false){
                dfs(computers, j, visited);
            }
        }
    }
}