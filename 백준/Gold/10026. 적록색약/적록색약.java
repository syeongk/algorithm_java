import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    char[][] graph;
    int N;
    boolean[][] visited;

    int count1;
    int count2;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        graph = new char[N][N];
        visited = new boolean[N][N];


        //적록색약X 그래프 초기화
        for (int i=0; i<N; i++){
            String line = br.readLine();
            for (int j=0; j<N; j++){
                graph[i][j] = line.charAt(j);
            }
        }

        //적록색약X DFS 탐색
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!visited[i][j]){
                    DFS(i,j);
                    count1 += 1;
                }
            }
        }

        //적록색약 그래프 & 방문배열 초기화
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                visited[i][j] = false;
                if (graph[i][j] == 'G'){
                    graph[i][j] = 'R';
                }
            }
        }

        //적록색약 DFS 탐색
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!visited[i][j]){
                    DFS(i,j);
                    count2 += 1;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    public void DFS(int x, int y){

        visited[x][y] = true;
        //상하좌우 좌표
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx <= N-1 && ny <= N-1 && !visited[nx][ny] && graph[x][y] == graph[nx][ny]){
                    DFS(nx, ny);
                }
        }
    }
}