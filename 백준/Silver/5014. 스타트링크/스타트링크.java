import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 변수
 * 건물 총 층수 : F
 * 스타트링크 층 : G
 * 강호가 있는 층 : S
 * 위로 이동 : U
 * 아래로 이동 : D
 *
 * 입력
 * 10 1 10 2 1 (F, S, G, U, D)
 *
 * 출력
 * 강호가 S 층에서 -> G 층에 도착하기 위해 "버튼을 최소 몇 번 눌러야" 하는가?
 * G 층에 갈 수 없으면 use the stairs 출력
 *
 * 조건
 * U, D 에 해당하는 층이 없을 때 이동X
 * 건물 1층 ~ F층 까지
 */

/**
 * 그래프 : 1차원 배열
 * 이동 방향 : U, D
 * 건물이 1층이면 0번 바로 출력
 * BFS 수행해서 G 층에 도착하면 바로 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int F = Integer.parseInt(input[0]); // 건물 총 층수
        int S = Integer.parseInt(input[1]); // 내가 있는 층
        int G = Integer.parseInt(input[2]); // 도착할 층
        int U = Integer.parseInt(input[3]); // 위로 한 번 이동
        int D = Integer.parseInt(input[4]); // 아래로 한 번 이동

        // 그래프 생성
        int[] g = new int[F+1];
        // 방문하지 않은 층
        Arrays.fill(g, -1);

         // 건물이 1층이면 0번 바로 출력
        if (S == G) {
            System.out.println(0);
            return;
        }

        // BFS 수행
        Queue<Integer> q = new ArrayDeque<>(); // q 생성
        q.offer(S); // q 에 시작 위치 넣기
        g[S] = 0;

        while(!q.isEmpty()){
            int cur = q.poll(); // 현재 정점
            int[] moves = {cur + U, cur - D};  // 현재 정점에 대해 2가지 방향

            for (int move : moves){ // 현재 정점에 대해 2가지 방향 이동
                // 범위를 벗어났을 때
                if (move < 1 || move > F) continue;

                // 이미 방문했을 때
                if (g[move] != -1) continue;

                g[move] = g[cur] + 1;
                q.offer(move);

                if (move == G){
                    System.out.println(g[move]);
                    return;
                }
            }
        }
        System.out.println("use the stairs");
    }
}
