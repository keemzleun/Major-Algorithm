package A5dp;

public class D2멀리뛰기 {
    public static void main(String[] args) {
        int n = 4;  // 예상 결과값 = 5
        System.out.println(solution(n));
    }
    public static long solution(int n) {
        long answer = 0;
        // 식 : f(n) = f(n-1) + f(n-2)
        int[] arr = new int[4+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i<=n; i++){
            arr[i] = arr[i-1]%1234567 + arr[i-2]%1234567;
        }
        answer = arr[n];
        return answer;
    }
}
