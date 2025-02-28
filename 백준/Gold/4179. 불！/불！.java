import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 미로 행
        int C = Integer.parseInt(st.nextToken()); // 미로 열

        // 미로(그래프) 생성
        String[][] g = new String[R][C];
        int[] J = new int[1];
        ArrayList<int[]> F = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                g[i][j] = input.charAt(j) + "";
                if ("J".equals(g[i][j]))
                    J = new int[]{i, j};
                else if ("F".equals(g[i][j]))
                    F.add(new int[]{i, j});
            }
        }


        // 상 하 좌 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // F에 대한 BFS 수행
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] f : F)
            q.offer(f);

        int time = 1;
        while (!q.isEmpty()) {
            // 모든 F 에 대해서 한번씩 수행
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] now = q.poll();

                // 4 방향에 대해 탐색
                for (int j = 0; j < 4; j++) {
                    int x = now[0] + dx[j];
                    int y = now[1] + dy[j];

                    // 범위 내에 있고, '.' 인 부분에 대해서 시간 체크
                    if (x >= 0 && y >= 0 && x < R && y < C && ".".equals(g[x][y])) {
                        q.offer(new int[]{x, y});
                        g[x][y] = time + "";
                    }
                }
            }
            time++;
        }

        boolean[][] visited = new boolean[R][C];
        time = 0;

        // J가 이미 가장자리에 있는 경우 바로 탈출
        if (J[0] == 0 || J[0] == R - 1 || J[1] == 0 || J[1] == C - 1) {
            System.out.println(time + 1);
            return;
        }

        // J에 대한 BFS 수행
        q.offer(J);
        visited[J[0]][J[1]] = true;

        while (!q.isEmpty()) {
            time++;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = now[0] + dx[j];
                    int y = now[1] + dy[j];

                    // (x, y) 가 범위 내에 있지 않은 경우
                    if (x < 0 || y < 0 || x >= R || y >= C)
                        continue;

                    // (x, y) 를 이미 방문한 경우
                    if (visited[x][y])
                        continue;

                    // (x, y) 가 숫자가 아닌 경우
                    if ("F".equals(g[x][y]) || "#".equals(g[x][y]) || "J".equals(g[x][y]))
                        continue;

                    // 숫자가 더 큰 경우
                    if (!".".equals(g[x][y])) {
                        if (Integer.parseInt(g[x][y]) <= time)
                            continue;
                    }

                    // (x, y) 가 가장자리에 있는 경우
                    if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
                        System.out.println(time + 1);
                        return;
                    }

                    q.offer(new int[]{x, y});
                    visited[x][y] = true;

                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

}
