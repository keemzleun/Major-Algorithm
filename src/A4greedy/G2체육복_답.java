package A4greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class G2체육복_답 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int solution = solution(n, lost, reserve);
        System.out.println("solution = " + solution);
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> lostSet = new HashSet<>();
        Arrays.sort(reserve);
        for (int l : lost) {
            lostSet.add(l);
        }

        for (int i = 0; i < reserve.length; i++) {
            if(lostSet.contains(reserve[i])) {
                lostSet.remove(reserve[i]);
                reserve[i] = -1;
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            if(reserve[i] == -1) continue;
            if(lostSet.contains(reserve[i] - 1)) {
                lostSet.remove(reserve[i] - 1);
            } else if (lostSet.contains(reserve[i] + 1)) {
                lostSet.remove(reserve[i] + 1);
            }
        }
        answer = n - lostSet.size();
        return answer;
    }
}