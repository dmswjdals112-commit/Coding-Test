import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (a[i] > start) start = a[i];
            end += a[i];
        }

        int result = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0, count = 1;

            for (int x : a) {
                if (sum + x > mid) {
                    sum = x;
                    count++;
                } else sum += x;
            }

            if (count <= m) {
                result = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        System.out.println(result);
    }
}
