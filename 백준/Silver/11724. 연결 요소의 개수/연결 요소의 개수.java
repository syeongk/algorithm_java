import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 N
        int M = Integer.parseInt(st.nextToken()); // 간선 M

        // 그래프 생성
        g = new ArrayList<>();

        for (int i=0; i<=N; i++){
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            g.get(num1).add(num2);
            g.get(num2).add(num1);
        }

        visited = new boolean[N+1];
        int cnt = 0;
        // 1부터 N까지 DFS 수행
        for (int i=1; i<=N; i++){
            if (!visited[i]){
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int cur){
        ArrayList<Integer> adjList = g.get(cur);
        for (int adj : adjList){
            if (visited[adj]) continue;
            visited[adj] = true;
            dfs(adj);
        }
    }
}
