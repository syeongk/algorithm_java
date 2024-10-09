import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int cnt = 0;
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] arr = input.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (cnt == -1){
                break;
            }
            if (arr[i] == 'X') {
                cnt += 1;
                if (i == arr.length - 1) {
                    cnt = poli(cnt, arr, i);
                    break;
                }
            } else if (arr[i] == '.') {
                cnt = poli(cnt, arr, i-1);

            }


        }
        if (cnt==-1){
            System.out.println(-1);
        } else {
            System.out.println(arr);
        }
    }

    private static int poli(int cnt, char[] arr, int i) {

        if (cnt % 4 == 2) {
            for (int j = 1; j <= 4 * (cnt/4) ; j++){
                arr[i-(cnt-j)] = 'A';
            }
            for (int j = 0; j < 2 ; j++){
                arr[i - j] = 'B';
            }
        } else if (cnt % 4 == 0) {
            for (int j = 1; j <= cnt; j++) {
                arr[i-(cnt-j)] = 'A';
            }
        } else if (cnt % 2 == 0) {
            for (int j = 1; j <= cnt; j++) {
                arr[i-(cnt-j)] = 'B';
            }
        } else {
            return -1;
        }

        cnt = 0;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

