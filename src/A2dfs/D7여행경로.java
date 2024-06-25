package A2dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D7여행경로 {

    static boolean[] visited;
    static List<String> allRoute;
    public static void main(String[] args) {
            String[] answer = {};
            String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
            int cnt = 0;

            visited = new boolean[tickets.length];
            allRoute = new ArrayList<>();

            dfs(tickets,"ICN", "ICN",  cnt);

            Collections.sort(allRoute);
//            System.out.println(allRoute);
            answer = allRoute.get(0).split(" ");

            System.out.println(Arrays.toString(answer));
        }

        public static void dfs(String[][] tickets ,String start, String route, int cnt) {
            if (cnt == tickets.length) {  // 횟수와 티겟수와 같을경우
                allRoute.add(route); //allRoute(모든 경우의 수)에 추가
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (start.equals(tickets[i][0]) && !visited[i]) {
                    visited[i] = true;
//                    rout 부분에 다음가는곳을 띄어쓰기 해주고 추가해준다.
                    dfs(tickets, tickets[i][1], route + " " + tickets[i][1], cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }


