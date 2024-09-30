import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public void solution() throws IOException {

        HashMap<String, String> name = new HashMap<>();
        HashMap<String, String> num = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<n+1; i++){
            String poketmon = br.readLine();
            name.put(poketmon, Integer.toString(i));
            num.put(Integer.toString(i), poketmon);
        }

        for (int i=0; i<m; i++){
            String q = br.readLine();
            if(name.containsKey(q)){
                sb.append(name.get(q)).append("\n");
            } else if(num.containsKey(q)) {
                sb.append(num.get(q)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
