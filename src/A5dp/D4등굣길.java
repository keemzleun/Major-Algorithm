package A5dp;

public class D4등굣길 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m, n, puddles));
    }
    public static int solution(int m, int n, int[][] puddles) {
        int count = 0;
        int[][] map = new int[n][m];
        for (int[] p : puddles){
            map[p[1]-1][p[0]-1] = -1;
        }
        map[0][0] = 1;

        // 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != -1){
                    if (map[i+1][j] >= 1 && map[i+1][j] != -1) {

                    }
                    if (map[i][j+1] >= 1 && map[i][j+1] != -1) {

                    }
                }
            }
        }
        // map[n][m-1] + map[n-1][m]을 리턴???
        return count;
    }
}
