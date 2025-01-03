import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, reverseOrder());

        double sum = arr[0];
        for (int i = 1; i < n; i++){
            sum += (float) arr[i] / 2;
        }
        if (sum % 1 == 0)
            System.out.println((long) sum);
        else
            System.out.println(sum);
    }
}
