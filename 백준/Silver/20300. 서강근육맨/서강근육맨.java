import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] t = new long[n];
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for (int i=0; i<n; i++){
            t[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(t);

        long max = 0;
        for (int i=0; i<n/2; i++){
            if (n%2 == 0){
                max = Math.max(max, t[i] + t[n - (i+1)]);
            } else {
                max = Math.max(max, t[i] + t[n - (i+2)]);
            }
        }
        max = Math.max(max, t[n-1]);

        System.out.println(max);
    }
}
