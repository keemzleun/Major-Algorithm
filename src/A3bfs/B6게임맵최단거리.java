package A3bfs;

import java.util.LinkedList;
import java.util.Queue;

public class B6게임맵최단거리 {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};


        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});  // {x좌표, y좌표, distance}

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && !visited[nx][ny]) {
                    if (maps[nx][ny] == 1) {
                        q.add(new int[]{nx, ny, current[2] + 1});
                        visited[nx][ny] = true;
                        if (nx == maps.length - 1 && ny == maps[0].length - 1) {
                            answer = current[2] + 1;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
