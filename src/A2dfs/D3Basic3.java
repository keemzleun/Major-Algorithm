package A2dfs;

import java.util.ArrayList;
import java.util.List;

public class D3Basic3 {
    static List<List<Integer>> adjList;

    public static void main(String[] args) {
        // D2와 다른 점 ) 0부터 시작하지 않음 !
        // list, 배열 1개 넉넉하게 잡으면 됨
        // 출력 예시) [[1,2,4,8], [1,2,4,9], [1,2,5,10], [1,3,6], [1,3,7]];
        // 전체 리스트(이중 리스트), 부분 리스트(단일 리스트) 필요
        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};

        adjList = new ArrayList<>();

        for (int i=0; i<11; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] a : arr){
            adjList.get(a[0]).add(a[1]);
        }
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();     // 현재 경로를 저장
        temp.add(1);
        dfs(answer, temp, 1);
        System.out.println(answer);
    }

    static void dfs(List<List<Integer>> answer, List<Integer> temp, int start){
        if(adjList.get(start).isEmpty()){   // 더 이상 노드가 없으면 temp에 담겨진 값을 모두 answer 넣어 반환
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int target : adjList.get(start)){
            temp.add(target);           // 경로에 현재 노드를 추가
            dfs(answer, temp, target);  // 재귀 호출을 통해 다음 노드를 탐색
            temp.remove(temp.size()-1);     // 백트래킹.
        }
    }
}
