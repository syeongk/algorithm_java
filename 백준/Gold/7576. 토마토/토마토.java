import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 상자 세로
        int N = Integer.parseInt(st.nextToken()); // 상자 가로

        // 그래프 생성
        int[][] g = new int[N][M];
        int zeroCheck = 0;
        ArrayList<int[]> starts = new ArrayList<>();
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
                if (g[i][j] == 1)
                    starts.add(new int[]{i,j});
                if (g[i][j] == 0 && zeroCheck == 0)
                    zeroCheck = 1;
            }
        }

        // 모든 토마토가 익어있는 상태인지 체크
        if (zeroCheck == 0){
            System.out.println(0);
            return;
        }

        // 방향 설정 (상,하,좌,우)
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // BFS
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] start : starts)
            q.offer(start); // 시작 정점 추가
        int ans = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            for (int i=0; i<qSize; i++){
                int[] now = q.poll();
                for (int[] d : directions){
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];
                    if (x>=0 && y>=0 && x<N && y<M && g[x][y]==0){
                        q.add(new int[]{x, y});
                        g[x][y] = 1;
                    }
                }
            }
            ans+=1;
        }
        ans-=1;

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (g[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
    }
}
