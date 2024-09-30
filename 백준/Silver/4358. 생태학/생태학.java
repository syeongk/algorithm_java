import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Double> hm = new TreeMap<>();

        int total = 0;
        while(true){
            String str = br.readLine();
            if (str==null || str.equals("")){
                break;
            }
            total += 1;
            if (hm.containsKey(str)){
                double cnt = hm.get(str);
                hm.put(str, cnt+1);
            } else {
                hm.put(str, 1.0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String key : hm.keySet()){
            double value = hm.get(key);

            String value2 = String.format("%.4f", (value*100) / total);
            hm.put(key, Double.parseDouble(value2));
            sb.append(key).append(" ").append(value2).append('\n');
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
