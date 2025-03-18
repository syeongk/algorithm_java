import javax.management.loading.MLet;
import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // NxN 배열
        int M = Integer.parseInt(st.nextToken()); // 이동 횟수

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름
        ArrayList<int[]> cloud = new ArrayList<>();
        cloud.add(new int[]{N, 1});
        cloud.add(new int[]{N, 2});
        cloud.add(new int[]{N-1, 1});
        cloud.add(new int[]{N-1, 2});

        // 구름 이동 방향 8개
        int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1}; // 위 아래
        int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1}; // 왼쪽 오른쪽

        // 대각선 방향 4개 (시계 방향)
        int[] dx4 = {-1, 1, 1, -1};
        int[] dy4 = {1, 1, -1, -1};

        for (int i = 1; i <= M; i++) {

            // 1. 모든 구름이 di 방향으로 si칸 이동한다.
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 이동 방향
            int cnt = Integer.parseInt(st.nextToken()); // 이동 횟수

            // 구름 위치 이동
            for (int k = 0; k < cloud.size(); k++) {
                int[] cloudLoc = cloud.get(k);
                cloudLoc[0] += dx[dir]*cnt;
                cloudLoc[1] += dy[dir]*cnt;

                while (cloudLoc[0] <= 0 || cloudLoc[0] > N){
                    if (cloudLoc[0] > N){
                        cloudLoc[0] -= N;
                    }
                    if (cloudLoc[0] <= 0){
                        cloudLoc[0] += N;
                    }

                }
                while (cloudLoc[1] <= 0 || cloudLoc[1] > N){
                    if (cloudLoc[1] > N){
                        cloudLoc[1] -= N;
                    }
                    if (cloudLoc[1] <= 0) {
                        cloudLoc[1] += N;
                    }
                }

            }


            // 현재 구름 위치 저장
            boolean[][] cloudVisited = new boolean[N+1][N+1];
            for (int j=0; j<cloud.size(); j++){
                int[] cloudLoc = cloud.get(j);

                cloudVisited[cloudLoc[0]][cloudLoc[1]] = true;
            }

            // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            for (int j = 0; j < cloud.size(); j++) {
                arr[cloud.get(j)[0]][cloud.get(j)[1]] += 1;
            }

            // 3. 구름이 모두 사라진다.
            // 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
            for (int j = 0; j < cloud.size(); j++) { // 물이 증가한 칸 4개의 대각선 4 방향 확인
                for (int k = 0; k < 4; k++) { // 대각선 4 방향 확인
                    int x = cloud.get(j)[0] + dx4[k];
                    int y = cloud.get(j)[1] + dy4[k];

                    if (x < 1 || x > N || y < 1 || y > N) continue;

                    if (arr[cloud.get(j)[0] + dx4[k]][cloud.get(j)[1] + dy4[k]] >= 1) {
                        arr[cloud.get(j)[0]][cloud.get(j)[1]] += 1;
                    }
                }
            }
            cloud.clear();

            // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (arr[j][k] < 2) continue;
                    if (cloudVisited[j][k]) continue; // 기존에 구름이 사라진 칸인지 확인

                    arr[j][k] -= 2;
                    cloud.add(new int[]{j,k});
                }
            }
        }
        int ans = 0;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                ans += arr[i][j];
            }
        }
        System.out.println(ans);
    }
}
