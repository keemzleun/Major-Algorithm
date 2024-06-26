package A4greedy;

import java.util.Arrays;

public class G2체육복 {
    // 나의 풀이
    public static void main(String[] args) {
        int n = 10;
        int[] lost = {1, 2, 3, 4, 5, 6};
        int[] reserve = {1, 2, 3};

        System.out.println(solution(n, lost, reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int count = n - lost.length;
//        System.out.println(count);
        for (int i = 0; i< lost.length; i++){
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    count++;
                } else if (reserve[j] == lost[i]-1 || reserve[j] == lost[i]+1){
                    count++;
                }
                reserve[j] = -10;
                System.out.println(Arrays.toString(reserve));
            }
        }

        return count;
    }
}
