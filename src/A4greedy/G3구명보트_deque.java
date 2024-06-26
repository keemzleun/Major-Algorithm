package A4greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class G3구명보트_deque {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {

        Arrays.sort(people);  // 50, 50, 70, 80
        Deque<Integer> deq = new ArrayDeque<>();
        for (int p : people){
            deq.add(p);
        }
        int count = 0;
        while(!deq.isEmpty()){
            int e = deq.pollLast();
            count++;
            if (deq.size() >= 1 && e + deq.peekFirst() <= limit){
                deq.pollFirst();
            }
        }
        return count;
    }
}
