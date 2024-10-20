import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        TreeSet<String> set = new TreeSet<>((a,b)->{
            if(a.length()!=b.length())
                return a.length()-b.length();
            else
                return a.compareTo(b);
        });

        for (int i=0; i<n; i++){
            set.add(br.readLine());
        }

        for(String word : set){
            sb.append(word+"\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
