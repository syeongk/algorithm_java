import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 사람 수
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine()); // 간선 수

        if (N == 1){
            System.out.println(0);
            return;
        }

        // 그래프 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        int cnt = 0;
        boolean[] visited = new boolean[N+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{from, cnt});
        visited[from] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            ArrayList<Integer> arr = graph.get(now[0]);
            for (int num : arr) {
                if (visited[num]) continue;

                if (num == to) {
                    System.out.println(now[1] + 1);
                    return;
                }
                q.offer(new int[]{num, now[1] + 1});
                visited[num] = true;
            }
        }
        System.out.println(-1);
    }
}
