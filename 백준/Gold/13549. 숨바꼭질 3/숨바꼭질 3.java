import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // N과 K가 같을 때 0 출력
        if (N == K){
            System.out.println(0);
            return;
        }

        int[] arr = new int[100001];
        for (int i=0; i<100001; i++){
            arr[i] = -1;
        }
        arr[N] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                int cur = q.poll(); // 현재 위치

                // 걸을 때와 순간이동 할 때 나눠서
                // 순간이동 하는 경우
                int fastMove = cur * 2;

                // 수빈이의 시작 위치일 때 처리 X
                if (fastMove != N) {
                    // 순간이동 시 범위에서 벗어나면 처리 X
                    if (fastMove >= 0 && fastMove <= 100000) {
                        // 이미 방문한 곳이면 처리 X
                        if (arr[fastMove] == -1) {
                            // 나머지는 방문 처리
                            arr[fastMove] = arr[cur];
                            // 동생을 찾았다면 출력
                            if (fastMove == K) {
                                System.out.println(arr[fastMove]);
                                return;
                            }
                            q.offer(fastMove);
                        }
                    }
                }

                int[] walks = {cur - 1, cur + 1};
                for (int walk : walks) {
                    // 수빈이의 시작 위치일 때 처리 X
                    if (walk == N)
                        continue;
                    // 걸었을 때 범위에서 벗어나면 처리 X
                    if (walk < 0 || walk > 100000)
                        continue;
                    // 이미 방문한 곳이면 처리 X
                    if (arr[walk] != -1)
                        continue;

                    // 나머지는 방문 처리
                    arr[walk] = arr[cur] + 1;
                    // 동생을 찾았다면 출력
                    if (walk == K) {
                        System.out.println(arr[walk]);
                        return;
                    }
                    q.offer(walk);
                }
            }
        }
    }
}
