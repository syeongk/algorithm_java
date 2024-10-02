import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> hm = new HashMap<>();

        double total = 0.0;
        List<String> li = new ArrayList<>();
        while(true){
            String str = br.readLine();
            if (str==null || str.equals("")){
                break;
            }
            total += 1.0;
            if (!hm.containsKey(str)){
                li.add(str);
            }
            hm.put(str, hm.getOrDefault(str,0.0)+1.0);
        }
        Collections.sort(li);

        StringBuilder sb = new StringBuilder();
        for (String key : li){
            double value = hm.get(key) * 100;
            String value2 = String.format("%.4f", value / total);
            sb.append(key + " " + value2 + "\n");
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
