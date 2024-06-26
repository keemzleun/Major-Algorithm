package A4greedy;

import java.util.Arrays;

public class G3구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
    public static int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);  // 50, 50, 70, 80
        int s = 0;
        int e = people.length - 1;
        while(s <= e) {
            if (people[s] + people[e] <= limit) {
                s++;
            }
            e--;
            count++;
        }
        return count;
    }
}
