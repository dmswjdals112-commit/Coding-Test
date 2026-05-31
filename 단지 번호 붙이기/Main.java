import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL, HOUSE = '1', size;
  static char[][] A;
  static boolean[][] visited;

  static void DFS(int r, int c) {
    if (visited[r][c] || A[r][c] != HOUSE) return;
    visited[r][c] = true;
    ++size;
    if (r > 0) DFS(r-1, c);
    if (c > 0) DFS(r, c-1);
    if (r < ROW-1) DFS(r+1, c);
    if (c < COL-1) DFS(r, c+1);
  }

  static List<Integer> getComponentSizes() {
    visited = new boolean[ROW][COL];
    var sizes = new ArrayList<Integer>();
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (A[r][c] == HOUSE && !visited[r][c]) {
          size = 0;
          DFS(r, c);
          sizes.add(size);
        }
    return sizes;
  }

  public static void main(String[] args) throws IOException {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var tokenizer = new StringTokenizer(reader.readLine());
    ROW = Integer.parseInt(tokenizer.nextToken()); COL = ROW;
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = reader.readLine().toCharArray();
      
    List<Integer> sizes = getComponentSizes();
    Collections.sort(sizes);
    
    var builder = new StringBuilder();
    builder.append(sizes.size()).append('\n');
    for (int size : sizes)
      builder.append(size).append('\n');
    System.out.print(builder.toString());
  }
}
