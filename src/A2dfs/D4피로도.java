package A2dfs;

public class D4피로도 {
    static int count;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) {
        int answer = -1;
        int k = 80;     // 현재 피로도
        int[][] dungeons = {{80,20},{50,40},{30,10}};  // {최소 피로도, 소모 피로도}
        visited = new boolean[dungeons.length];
        max = 0;
        pirodo(dungeons, visited, k, 0);
        System.out.println(max);

    }
    static void pirodo(int[][] dungeons, boolean[] visited, int k, int count){
        if(max < count){
            max = count;
        }
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] == false && k >= dungeons[i][0]){
                visited[i] = true;
                pirodo(dungeons, visited, k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }

    }

}
