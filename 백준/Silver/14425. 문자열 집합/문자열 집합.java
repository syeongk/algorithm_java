import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();

        for (int i=0; i<n; i++){
            String str = br.readLine();
            hs.add(str);
            }

        int cnt = 0;
        for (int i=0; i<m; i++){
            String str = br.readLine();
            if (hs.contains(str)){
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
