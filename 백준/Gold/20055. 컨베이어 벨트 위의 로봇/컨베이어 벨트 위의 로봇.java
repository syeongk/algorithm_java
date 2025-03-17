import java.beans.AppletInitializer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 벨트의 길이
        int K = Integer.parseInt(st.nextToken()); // 내구도 0의 갯수
        int[] A = new int[N*2]; // 내구도 배열
        boolean[] robot = new boolean[N]; // 로봇 존재 여부 배열, 로봇은 올리는 위치에만 올릴 수 있다. 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다.

        // 내구도 저장
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N*2; i++){
            A[i] = Integer.parseInt(st.     nextToken());
        }

        int ans = 1;
        while (true) {
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다. 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다.
            int lastA = A[(N*2)-1]; // 마지막 칸 내구도

            // 내구도 1번부터 2N-1번까지의 칸은 다음 번호의 칸이 있는 위치로 이동, 2N번 칸은 1번 칸의 위치로 이동
            for (int i=(N*2)-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = lastA;
            // 로봇 1번부터 N-1번까지의 칸은 다음 번호의 칸이 있는 위치로 이동
            for (int i=N-2; i>=0; i--){
                robot[i+1] = robot[i];
            }
            robot[N-1] = false;
            robot[0] = false;

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다. 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다.
            // 2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            robot[N-1] = false;
            for (int i=N-2; i>=0; i--){
                if(robot[i] && A[i+1] >= 1 && !robot[i+1]) {
                    robot[i] = false;
                    robot[i+1] = true;
                    A[i+1]--;
                }
            }
            robot[N-1] = false;

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다. 로봇을 올리는 위치에 올리면 그 칸의 내구도는 즉시 1만큼 감소한다.
            if (A[0] != 0) {
                robot[0] = true;
                A[0]--;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            int check = 0;
            for (int i=0; i<N*2; i++){
                if (A[i] == 0) check++;
            }
            if (check >= K) {
                System.out.println(ans);
                break;
            }
            ans++;
        }



    }
}
