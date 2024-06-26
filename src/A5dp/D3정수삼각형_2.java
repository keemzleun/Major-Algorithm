package A5dp;

import java.util.Arrays;

public class D3정수삼각형_2 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
    public static int solution(int[][] triangle) {
        int[][] ansArr = new int[triangle.length][];
        ansArr[0] = Arrays.copyOf(triangle[0],triangle[0].length);

        for (int i = 0; i < triangle.length-1; i++) {
            ansArr[i] = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                if(ansArr[i][j] + triangle[i+1][j] > ansArr[i+1][j]){
                    ansArr[i+1][j] = ansArr[i][j] + triangle[i+1][j];
                }
                if(ansArr[i][j] + triangle[i+1][j+1] > ansArr[i+1][j+1]){
                    ansArr[i+1][j+1] = ansArr[i][j] + triangle[i+1][j+1];
                }
            }
        }
        System.out.println(Arrays.deepToString(ansArr));
        return 0;
    }


}
