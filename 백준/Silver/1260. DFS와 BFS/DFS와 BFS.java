import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static int N;
    private static int M;
    private static int V;
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    private static boolean[] visited1;
    private static boolean[] visited2;
    
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];
        
        for (int i=0; i<N+1; i++){
            g.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }

        for (ArrayList<Integer> li : g){
            Collections.sort(li);
        }

        DFS(V);
        sb.append("\n");
        BFS();
        System.out.println(sb);
        
    }
    
    
    public void BFS(){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(V);
        visited1[V] = true;
        sb.append(V + " ");
        
        
        while (!q.isEmpty()) {
            for (int v : g.get(q.poll())){
                if (visited1[v]==false){
                    q.offer(v);
                    visited1[v] = true;
                    sb.append(v + " ");
                }
            }
        }
        
    }

    public void DFS(int vertex){
        visited2[vertex] = true;
        sb.append(vertex + " ");

        for (int v : g.get(vertex)){
            if(visited2[v] == false){
                DFS(v);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}