import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 변수
 * N : 그래프 행, 열 (2 이상 100 이하)
 *
 * 입력
 * N
 * 2차원 그래프
 *
 * 출력
 * 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수
 *
 * 조건
 * 아무 지역도 물에 잠기지 않을 수 있음
 */

/**
 * 그래프 : 2차원 배열
 * 이동방향 : 상 하 좌 우
 * 방문배열 만들기
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] g = new int[N][N];
        int h = 1;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                g[i][j] = Integer.parseInt(st.nextToken());
                h = Math.max(h, g[i][j]);
            }
        }

        // 이동 방향
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        // 높이 1 ~ 100에 대한 안전 영역 갯수
        int[] safeAreas = new int[h+1];

        for (int i=0; i<=h; i++){ // 높이 1 ~ 100 만큼 반복
            boolean[][] visited = new boolean[N][N];
            Queue<int[]> q = new ArrayDeque<>();
            int safeCount = 0; // 높이 1 ~ 100에 대한 안전 영역 각 갯수
            for (int j=0; j<N; j++){
                for (int k=0; k<N; k++){
                    boolean block = false;
                    // 초기 방문
                    if (g[j][k] > i && !visited[j][k]) {
                        q.offer(new int[]{j, k});
                        visited[j][k] = true;
                    }
                    // 높이 i 이하인 지점은 모두 잠기도록 BFS 수행
                    while (!q.isEmpty()){
                        block = true;
                        int[] cur = q.poll();
                        for (int a=0; a<4; a++){
                            int x = cur[0] + dx[a];
                            int y = cur[1] + dy[a];

                            // 범위를 벗어났는지 확인
                            if (x < 0 || x >= N || y < 0 || y >= N) continue;

                            // 이미 방문했는지 확인
                            if (visited[x][y]) continue;

                            // 높이 i 이하인지 확인 (잠기는지 확인)
                            if (g[x][y] <= i) continue;

                            // 방문 처리
                            visited[x][y] = true;
                            q.offer(new int[]{x,y});
                        }
                    }
                    if (block){
                        safeCount++;
                    }
                }
            }
            safeAreas[i] = safeCount;
        }

        Arrays.sort(safeAreas);
        System.out.println(safeAreas[h]);
    }
}
