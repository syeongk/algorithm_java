import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];

        for (int i=0; i<n; i++){
            level[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i=n-1; i>0; i--){
            if (level[i] <= level[i - 1]) {
                cnt += level[i - 1] - level[i] + 1;
                level[i - 1] = level[i] - 1;
            }
        }
        System.out.println(cnt);

    }
}
