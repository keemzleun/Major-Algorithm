package A4greedy;

public class G1GreedyBasic {
    public static void main(String[] args) {
        // 1, 5, 10, 20 숫자를 조합하여 99를 만들 수 있는 조합 중 가장 짧은 조합의 길이
        int[] arr = {1, 5, 10, 20};
        int goal = 99;
        int count = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (goal >= arr[i]) {
                count += goal / arr[i];
                goal = goal % arr[i];
            }
        }
        System.out.println(count);
    }
}
