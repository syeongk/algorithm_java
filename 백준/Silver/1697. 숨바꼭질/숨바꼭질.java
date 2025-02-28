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
        int M = Integer.parseInt(input[1]);

        // 수빈이와 동생의 위치가 같은 경우
        if (N == M){
            System.out.println(0);
            return;
        }

        int[] arr = new int[100001];
        for (int i=0; i<=100000; i++){
            arr[i] = -1;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N); // 수빈이의 위치 (배열 인덱스)
        arr[N] = 0;

        while(!q.isEmpty()){
            int now = q.poll(); // 수빈이의 현재 위치
            int[] idxs = {now - 1, now + 1, now * 2};

            for (int idx : idxs) {
                // 범위가 넘어가는 경우 처리X
                if (idx < 0 || idx > 100000)
                    continue;

                // arr[idx] 를 이미 방문한 경우 처리X
                if (arr[idx] != -1)
                    continue;

                arr[idx] = arr[now] + 1; // 방문 처리
                // 수빈이가 동생을 찾은 경우 시간 출력
                if (idx == M) {
                    System.out.println(arr[idx]);
                    return;
                }
                q.offer(idx);

            }

        }

    }
}
