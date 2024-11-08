import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int N;
    int M;
    int K;
    int[][] g;
    boolean[][] visited;
    Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            g = new int[N][M];
            visited = new boolean[N][M];

            // 2차원 배열 NxM 크기 만들고, visited 배열 초기화
            for (int j=0; j<N; j++){
                for (int k=0; k<M; k++){
                    g[j][k] = 0;
                    visited[j][k] = false;
                }
            }

            // 2차원 배열에서 배추 심어진 부분 -> 1
            for (int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                g[x][y] = 1;
            }

            System.out.println(BFS());



         /* 테스트 출력
        for (int j=0; j<N; j++){
            for (int k=0; k<M; k++){
                System.out.print(g[j][k]);
            }
            System.out.println();
        }

          */

        }


    }

    public int BFS() {
        int count = 0;

        //인접노드 접근하기 위한 상하좌우
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (g[i][j] == 1 && !visited[i][j]){
                    q.offer(new int[] {i,j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int[] dir : direction) {
                            int x = now[0] + dir[0];
                            int y = now[1] + dir[1];

                            if (x >= 0 && y >= 0 && x <= N - 1 && y <= M - 1) {
                                if (!visited[x][y] && g[x][y] == 1) {
                                    q.offer(new int[]{x, y});
                                    visited[x][y] = true;
                                }
                            }
                        }
                    }
                    count += 1;

                    }
                }
            }

        return count;

    }
}
