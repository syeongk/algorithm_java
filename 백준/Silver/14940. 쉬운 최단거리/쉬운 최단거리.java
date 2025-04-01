import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();

        int[][] arr = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][m];

        int[] goal = q.peek();
        arr[goal[0]][goal[1]] = 0;
        visited[goal[0]][goal[1]] = true;

        while(!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + dx[j];
                    int y = cur[1] + dy[j];

                    // 범위 넘어가는 경우
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;

                    // 0인 경우
                    if (arr[x][y] != 1) continue;

                    // 이미 방문한 경우
                    if (visited[x][y]) continue;

                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                    arr[x][y] = arr[cur[0]][cur[1]]+1;

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (arr[i][j] == 1 && !visited[i][j]){
                    sb.append(-1 + " ");
                } else {
                    sb.append(arr[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
