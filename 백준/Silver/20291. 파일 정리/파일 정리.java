import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        TreeMap<String, Integer> tm = new TreeMap<>();

        for (int i=0; i<N ; i++){
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String name = st.nextToken();
            tm.put(name, tm.getOrDefault(name,0)+1 );
        }
        StringBuilder sb = new StringBuilder();
        for (String key : tm.keySet()){
            int count = tm.get(key);
            sb.append(key).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
