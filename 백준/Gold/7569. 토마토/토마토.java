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
        int C = Integer.parseInt(st.nextToken()); // 5
        int R = Integer.parseInt(st.nextToken()); // 3
        int H = Integer.parseInt(st.nextToken()); // 1
        Queue<int[]> q = new ArrayDeque<>();

        int[][][] box = new int[R][C][H];
        for (int i=0; i<H; i++){
            for (int j=0; j<R; j++){
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<C; k++){
                    box[j][k][i] = Integer.parseInt(st.nextToken());
                    if (box[j][k][i] == 1){
                        q.offer(new int[]{j,k,i}); // 익은 토마토 큐에 넣음
                    }
                }
            }
        }

        // 위, 아래, 상, 하, 좌, 우
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, -1, 1};
        int[] dz = {-1, 1, 0, 0, 0, 0};

        while (!q.isEmpty()){
            int[] cur = q.poll();

            for (int i=0; i<6; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                int z = cur[2] + dz[i];

                // x,y,z 범위가 벗어나면 처리 X
                if (x < 0 || x >= R || y < 0 || y >= C || z < 0 || z >= H)
                    continue;

                // 이미 방문했거나, 토마토가 들어가있지 않으면 처리 X
                if (box[x][y][z] != 0)
                    continue;

                // 나머지는 처리
                box[x][y][z] = box[cur[0]][cur[1]][cur[2]] + 1;
                q.offer(new int[]{x,y,z});
            }
        }

        int time = 0;
        for (int i=0; i<H; i++){
            for (int j=0; j<R; j++){
                for (int k=0; k<C; k++){
                    if (box[j][k][i] == 0){
                        System.out.println(-1);
                        return;
                    }
                    time = Math.max(time, box[j][k][i]-1);
                }
            }
        }
        System.out.println(time);

    }
}
