import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // 시계 방향으로 움직일 수 있는 칸
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; // 위, 아래
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1}; // 왼쪽, 오른쪽

        for (int i=0; i<n; i++){
            // 체스판 사이즈
            int size = Integer.parseInt(br.readLine());
            int[][] g = new int[size][size];

            for (int j=0; j<size; j++){
                for (int k=0; k<size; k++){
                    g[j][k] = -1;
                }
            }

            // 나이트 위치
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int[] knight = {x1, y1};

            // 나이트 목표 위치
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int[] point = {x2, y2};

            // 나이트 위치와 목표 위치가 같을 때
            if (knight[0] == point[0] && knight[1] == point[1]){
                sb.append(0 + "\n");
            }

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(knight);
            g[x1][y1] = 0;
            while(!q.isEmpty()){
                int[] cur = q.poll();

                for (int j=0; j<8; j++){
                    int x = cur[0] + dx[j];
                    int y = cur[1] + dy[j];

                    // 체스판 사이즈 넘어가면 처리 X
                    if (x < 0 || x >= size || y < 0 || y >= size)
                        continue;
                    // 이미 방문한 곳이면 처리 X
                    if (g[x][y] != -1)
                        continue;

                    g[x][y] = g[cur[0]][cur[1]] + 1;

                    // 도착하고자 하는 위치에 도착했을 때
                    if (point[0] == x && point[1] == y) {
                        sb.append(g[x][y] + "\n");
                        q.clear();
                        break;
                    }
                    q.offer(new int[]{x,y});
                }
            }
        }
        System.out.println(sb);
    }
}
