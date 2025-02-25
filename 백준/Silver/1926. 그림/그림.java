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
        int n = Integer.parseInt(st.nextToken()); // 행의 크기
        int m = Integer.parseInt(st.nextToken()); // 열의 크기

        // 그래프 생성
        int[][] g = new int[n][m];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상 하 좌 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();

        int paint = 0;
        int maxAreaPaint= 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (g[i][j]==1){
                    q.offer(new int[]{i,j});
                    g[i][j] = 2;

                    int area = 1;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for (int k=0; k<4; k++){
                            int x = now[0] + dx[k];
                            int y = now[1] + dy[k];
                            if (x >= 0 && y >= 0 && x < n && y < m && g[x][y] == 1){
                                q.offer(new int[]{x,y});
                                g[x][y] = 2;
                                area++;
                            }
                        }
                    }
                    maxAreaPaint = Math.max(maxAreaPaint, area);
                    paint++;
                }
            }
        }
        System.out.println(paint);
        System.out.println(maxAreaPaint);
    }
}
