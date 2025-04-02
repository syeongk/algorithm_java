import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[21];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch(str){
                case "add" :
                    arr[x] = true;
                    break;

                case "remove" :
                    arr[x] = false;
                    break;

                case "check" :
                    if (arr[x]) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "toggle" :
                    if (arr[x]) {
                        arr[x] = false;
                    } else {
                        arr[x] = true;
                    }
                    break;
                case "all" :
                    for (int j=1; j<=20; j++){
                        arr[j] = true;
                    }
                    break;
                case "empty" :
                    for (int j=1; j<=20; j++){
                        arr[j] = false;
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
