import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[n];

        for (int i=0; i<n; i++){
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips, Collections.reverseOrder());

        long sum = 0;
        for (int i=0; i<n; i++){
            if (tips[i] - i < 0)
                continue;
            sum += (tips[i] - i);
        }

        System.out.println(sum);
    }
}
