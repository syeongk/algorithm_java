import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            String str = br.readLine();
            if (str==null || str.equals("")){
                break;
            }

            st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();
            String output = "";

            int idx = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = idx; j < t.length(); j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        idx = j + 1;
                        output += s.charAt(i);
                        break;
                    }
                }
            }
            if (output.equals(s))
                sb.append("Yes").append("\n");
            else
                sb.append("No").append("\n");
        }
        System.out.println(sb);
    }
}
