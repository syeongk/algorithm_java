import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean check;

        for (int i = 0; i < n; i++) {
            check = false;
            String[] input = br.readLine().split(" ");
            int C = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);

            Queue<int[]> q = new ArrayDeque<>();
            int[] S = new int[2];

            // 그래프 생성
            String[][] map = new String[R][C];
            for (int j = 0; j < R; j++) {
                String line = br.readLine();
                for (int k = 0; k < C; k++) {
                    map[j][k] = line.charAt(k) + "";
                    if (map[j][k].equals("*")) {
                        map[j][k] = "0";
                        q.offer(new int[]{j, k});
                    } else if (map[j][k].equals("@")) {
                        S = new int[]{j, k};
                        map[j][k] = ".";
                    }
                }
            }

            // 이미 상근이가 가장자리에 있을 때
            if (S[0] == 0 || S[0] == R - 1 || S[1] == 0 || S[1] == C - 1) {
                System.out.println(1);
                continue;
            }

            // 이동 방향 (상, 하, 좌, 우)
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            // 불에 대한 BFS 수행
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];

                    // map[x][y] 가 범위를 벗어났는지 확인
                    if (x < 0 || x >= R || y < 0 || y >= C) continue;

                    // map[x][y] 로 이동할 수 있는지 확인 (방문 X)
                    if (map[x][y].equals(".")) {
                        map[x][y] = String.valueOf(Integer.parseInt(map[cur[0]][cur[1]]) + 1);
                        q.offer(new int[]{x, y});
                    }
                }
            }

            q.offer(S);
            int time = 0;
            boolean[][] visited = new boolean[R][C];
            // 상근이에 대한 BFS 수행
            while (!q.isEmpty()) {
                time++;
                int qSize = q.size();

                // 큐 안에 있는 위치는 시간이 동일
                for (int s = 0; s < qSize; s++) {
                    if (check)
                        break;
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = cur[0] + dx[k];
                        int y = cur[1] + dy[k];

                        // map[x][y] 가 범위를 벗어났는지 확인
                        if (x < 0 || x >= R || y < 0 || y >= C) continue;

                        // 이미 방문한 곳인지 확인
                        if (visited[x][y]) continue;

                        // 벽으로 이동 불가
                        if (map[x][y].equals("#")) continue;

                        // time 이 map 에 있는 숫자와 같거나 크면 이동 불가
                        if (!map[x][y].equals(".") && time >= Integer.parseInt(map[x][y])) continue;

                        q.offer(new int[]{x, y});
                        visited[x][y] = true;

                        // 가장자리에 도착한 경우
                        if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
                            check = true;
                            q.clear();
                            break;
                        }
                    }
                }
            }
            if (!check)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(time + 1);
        }
    }
}
