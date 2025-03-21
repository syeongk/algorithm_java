import java.util.*;
// 상대 팀 진영에 도착할 수 없을 때 -1
// 상대 팀 진영에 가장 빨리 도착하는 칸 수
// 0은 벽이 있는 자리, 1은 벽이 없는 자리 (지나갈 수 있음)
// 캐릭터 위치 (1,1), 상대방 위치 (n,m)
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 5
        int m = maps[0].length; // 5

        // 이동 방향 설정 (상,하,좌,우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 시작 위치 큐에 넣음
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        maps[0][0] = 2;
        
        // BFS 수행
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for (int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                // 범위를 벗어난 경우
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                
                // 막혀있거나 이미 방문한 경우
                if (maps[x][y] != 1) continue;
                
                // 나머지 방문 처리
                maps[x][y] = maps[now[0]][now[1]] + 1;
                q.offer(new int[]{x,y});
                
                // 상대방 위치에 도착한 경우
                if (x == n-1 && y == m-1) {
                    return maps[n-1][m-1] - 1;
                }
            }
        }
        
        // 상대방 위치에 도착하지 못한 경우
        return -1;
    }
}