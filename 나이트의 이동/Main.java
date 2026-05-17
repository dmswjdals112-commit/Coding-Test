import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int L = Integer.parseInt(reader.readLine());
            
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(reader.readLine());
            int destR = Integer.parseInt(st.nextToken());
            int destC = Integer.parseInt(st.nextToken());
            
            sb.append(bfs(L, startR, startC, destR, destC)).append("\n");
        }
        System.out.print(sb);
    }

    public static int bfs(int L, int startR, int startC, int destR, int destC) {
        if (startR == destR && startC == destC) {
            return 0;
        }

        int ROW = L;
        int COL = L;
        boolean[][] visited = new boolean[ROW][COL];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {startR, startC, 0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int distance = curr[2];

            if (r == destR && c == destC) {
                return distance;
            }

            if (r - 2 >= 0 && c - 1 >= 0 && !visited[r - 2][c - 1]) {
                visited[r - 2][c - 1] = true;
                queue.add(new int[] {r - 2, c - 1, distance + 1});
            }
            if (r - 2 >= 0 && c + 1 < COL && !visited[r - 2][c + 1]) {
                visited[r - 2][c + 1] = true;
                queue.add(new int[] {r - 2, c + 1, distance + 1});
            }
            if (r - 1 >= 0 && c + 2 < COL && !visited[r - 1][c + 2]) {
                visited[r - 1][c + 2] = true;
                queue.add(new int[] {r - 1, c + 2, distance + 1});
            }
            if (r + 1 < ROW && c + 2 < COL && !visited[r + 1][c + 2]) {
                visited[r + 1][c + 2] = true;
                queue.add(new int[] {r + 1, c + 2, distance + 1});
            }
            if (r + 2 < ROW && c + 1 < COL && !visited[r + 2][c + 1]) {
                visited[r + 2][c + 1] = true;
                queue.add(new int[] {r + 2, c + 1, distance + 1});
            }
            if (r + 2 < ROW && c - 1 >= 0 && !visited[r + 2][c - 1]) {
                visited[r + 2][c - 1] = true;
                queue.add(new int[] {r + 2, c - 1, distance + 1});
            }
            if (r + 1 < ROW && c - 2 >= 0 && !visited[r + 1][c - 2]) {
                visited[r + 1][c - 2] = true;
                queue.add(new int[] {r + 1, c - 2, distance + 1});
            }
            if (r - 1 >= 0 && c - 2 >= 0 && !visited[r - 1][c - 2]) {
                visited[r - 1][c - 2] = true;
                queue.add(new int[] {r - 1, c - 2, distance + 1});
            }
        }
        return -1;
    }
}
