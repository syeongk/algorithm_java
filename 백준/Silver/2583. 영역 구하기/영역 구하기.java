import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 행
        int C = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 직사각형 개수

        // 그래프 생성
        int[][] graph = new int[R][C];

        // 이동 방향
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    graph[k][j] = 1;
                }
            }
        }

        ArrayList<Integer> areas = new ArrayList<>();
        int area = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                area = 0;
                if (graph[i][j] == 0){
                    q.offer(new int[]{i, j});
                    graph[i][j] = 1;
                    area++;
                }
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = cur[0] + dx[k];
                        int y = cur[1] + dy[k];

                        if (x < 0 || x >= R || y < 0 || y >= C) continue;

                        if (graph[x][y] == 1) continue;

                        graph[x][y] = 1;
                        q.offer(new int[]{x, y});
                        area++;
                    }
                }
                if (area > 0) {
                    areas.add(area);
                }
            }
        }
        System.out.println(areas.size());
        Collections.sort(areas);
        for (int a : areas) {
            System.out.print(a + " ");
        }

    }
}
