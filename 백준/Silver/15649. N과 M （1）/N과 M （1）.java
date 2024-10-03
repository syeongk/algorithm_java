import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] nums;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        nums = new int[n];

        for (int i=0; i<n; i++){
            visited[i] = false;
            nums[i]= i+1;
        }


        backtrack(0, "");
        System.out.println(sb);
    }

    public static void backtrack(int cnt, String current) {
        if (cnt == m){
            sb.append(current + "\n");
            return;
        }

        for (int i=0; i<n; i++){
            if (!visited[i]){
                visited[i] = true;
                String str = nums[i] + " ";
                backtrack(cnt+1, current + str);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
