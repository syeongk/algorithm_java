import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int N, K;
    static String[] cards;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cards = new String[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            cards[i] = br.readLine();
        }

        // 백트래킹 시작
        backtrack(0, "");
        System.out.println(set.size());
    }

    // 백트래킹 메서드
    public static void backtrack(int count, String current) {
        if (count == K) {
            set.add(current); // K개의 카드를 선택했을 때 HashSet에 추가
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 아직 선택하지 않은 카드일 경우
                visited[i] = true; // 방문 표시
                backtrack(count + 1, current + cards[i]); // 카드를 선택하고 이어 붙임
                visited[i] = false; // 방문 표시 해제 (다른 경우의 수를 찾기 위해)
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
