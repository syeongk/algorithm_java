import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int to; //가리키는 노드
        int weight; //가중치

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[V+1]; //정점 V개에 대한 인접 노드를 저장하기 위한 인접 리스트

        for (int i=0; i<V+1; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //시작 정점 u
            int v = Integer.parseInt(st.nextToken()); //도착 정점 v
            int w = Integer.parseInt(st.nextToken()); //간선의 가중치

            graph[u].add(new Node(v, w)); //정점 u의 인접 리스트에 노드(인접 노드 v, 가중치 w) 추가
        }

        //최단경로 배열 초기화 (정점 V개에 대해, 0번 인덱스 사용X)
        int[] distance = new int[V+1];
        for (int i=0; i<V+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int currentNode = current.to;
            int currentWeight = current.weight;

            if (currentWeight > distance[currentNode])
                continue;

            for (Node neighbor : graph[currentNode]){
                int neighborNode = neighbor.to;
                int neighborWeight = neighbor.weight;

                if (currentWeight + neighborWeight < distance[neighborNode]) {
                    distance[neighborNode] = currentWeight + neighborWeight;
                    pq.offer(new Node(neighborNode, currentWeight + neighborWeight));
                }

            }
        }

        for (int i=1; i<V+1; i++){
            if (distance[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }

    }
}
