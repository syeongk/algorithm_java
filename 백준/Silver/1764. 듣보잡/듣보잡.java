import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<n; i++){
            String name = br.readLine();
            hs.add(name);
        }

        List<String> names = new ArrayList<>();
        for(int i=0; i<m; i++){
            String name = br.readLine();
            if (!hs.add(name)){
                names.add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(names);
        sb.append(names.size()).append("\n");
        for(String name : names){
            sb.append(name).append("\n");
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
