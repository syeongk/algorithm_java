
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] i1 = br.readLine().split(" ");

        int N = Integer.parseInt(i1[0]);
        int X = Integer.parseInt(i1[1]);

        String[] i2 = br.readLine().split(" ");

        for (int i=0; i<N; i++){
            if (X > Integer.parseInt(i2[i])){
                sb.append(i2[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}